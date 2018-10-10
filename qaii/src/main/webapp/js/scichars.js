//科研成果预览示例图
function circle(boxid,id,color,total,num){//id为canvas的id值,color为基本外圆颜色值,total为圆铺满总量,num为数据量
	var canvas=document.getElementById(id),
	context=canvas.getContext("2d");
	var canvasBox = document.getElementById(boxid).offsetWidth;
	canvas.width = canvasBox*0.8;
	var part=Math.PI*2*num/total-Math.PI/2;
	context.moveTo(canvas.width/2,canvas.height/2);
	context.beginPath();
	context.arc(canvas.width/2,canvas.height/2,canvas.width/2,0,Math.PI*2,false);
	context.strokeStyle="#fff";
	context.stroke();
	context.closePath();
	//外圈绘制
	context.moveTo(canvas.width/2,canvas.height/2);
	context.beginPath();
	context.lineWidth=canvas.width*58/540;
	context.arc(canvas.width/2,canvas.height/2,canvas.width*200/540,0,Math.PI*2,false);
	context.strokeStyle=color;
	context.stroke();
	context.closePath();
	//绘制内圈
	context.moveTo(canvas.width/2,canvas.height/2);
	context.beginPath();
	context.lineWidth=canvas.width*100/540;
	context.arc(canvas.width/2,canvas.height/2,canvas.width*220/540,-Math.PI/2,part,false);/*绘制图形所占比圆弧*/
	context.strokeStyle="#fff";
	context.stroke();
	context.closePath();
	//绘制比例圆
	context.font="bold 30px Arial";
	context.fillStyle = '#fff';
	context.textAlign="center";
	context.textBaseline="middle";
	context.fillText(num,canvas.width/2,canvas.height/2);
}

//政府资助点击事件tab切换
$(document).ready(function(){
  $(".tabbox ul li").click(function(){
    $(this).addClass("active").siblings().removeClass("active");
    var a= $(this).attr("name");
    $("#"+a).siblings().hide();
    $("#"+a).show();
  });
});
//科研成果信息
var myChart = echarts.init(document.getElementById('information'));
function getscientific(){
	var result=null;
	$.ajax({
		async:false,
		type:"POST",
		url:"scientific.do",
		success:function(data){
			result=data;
		}
	})
	return result;
}
var scientific=getscientific();
var option = {
	    tooltip: {
	        trigger: 'axis'
	    },
	    color: ['#3db4e3','#8fc31f', '#e4007f', '#601986', '#91c7ae','#fff100',  '#ea7542', '#48efef','#ef4566'],
	    legend: {
	        data:['受理专利','授权专利','申请软著','授权软著','受理商标','授权商标','论文总数','著作总数'],
	        textStyle:{    //图例文字的样式
	            color:'#fff',
	            fontSize:12
	        }
	    },
	    grid: {
	        left: '3%',
	        right: '4%',
	        bottom: '3%',
	        containLabel: true
	    },
	    toolbox: {
	        feature: {
	            saveAsImage: {}
	        }
	    },
	    xAxis : [
            {
                type : 'category',
                boundaryGap: false,
    	        data: [new Date(scientific.EachMonth[11]).getMonth()+1+'月',new Date(scientific.EachMonth[10]).getMonth()+1+'月',new Date(scientific.EachMonth[9]).getMonth()+1+'月',
    	        	new Date(scientific.EachMonth[8]).getMonth()+1+'月',new Date(scientific.EachMonth[7]).getMonth()+1+'月',new Date(scientific.EachMonth[6]).getMonth()+1+'月',
    	        	new Date(scientific.EachMonth[5]).getMonth()+1+'月',new Date(scientific.EachMonth[4]).getMonth()+1+'月',new Date(scientific.EachMonth[3]).getMonth()+1+'月',
    	        	new Date(scientific.EachMonth[2]).getMonth()+1+'月',new Date(scientific.EachMonth[1]).getMonth()+1+'月',new Date(scientific.EachMonth[0]).getMonth()+1+'月'],
                axisLabel: {
                    show: true,
                    textStyle: {
                        color: '#3db4e3',
                        fontSize:12
                    },
                    lineStyle:{ 
                    	color:'#3db4e3' 
                    	/*width:8*/
                    }
                },
                splitLine: {
                    show: false,
                    lineStyle: {
                        color: ['#000']
                    }
                },
            }
        ],
	    yAxis : [
            {
            	type: 'value',
            	splitLine: {
                    show: true,
                    lineStyle: {
                        color: ['#3db4e3']
                    }
                },
                axisLabel: {
                    show: true,
                    textStyle: {
                        color: '#3db4e3',
                        fontSize:12
                    },
                    lineStyle:{ 
                    	color:'#3db4e3' 
                    	/*width:8*/
                    }
                }
            }
        ],
	    series: [
	        {
	            name:'受理专利',
	            type:'line',
	            data:[scientific.AgencyPatent[11], scientific.AgencyPatent[10], scientific.AgencyPatent[9], 
	            	scientific.AgencyPatent[8], scientific.AgencyPatent[7], scientific.AgencyPatent[6], 
	            	scientific.AgencyPatent[5], scientific.AgencyPatent[4], scientific.AgencyPatent[3],
	            	scientific.AgencyPatent[2], scientific.AgencyPatent[1], scientific.AgencyPatent[0]]
	        },
	        {
	            name:'授权专利',
	            type:'line',
	            data:[scientific.AuthorizationPatent[11], scientific.AuthorizationPatent[10], scientific.AuthorizationPatent[9], 
	            	scientific.AuthorizationPatent[8], scientific.AuthorizationPatent[7], scientific.AuthorizationPatent[6], 
	            	scientific.AuthorizationPatent[5], scientific.AuthorizationPatent[4], scientific.AuthorizationPatent[3],
	            	scientific.AuthorizationPatent[2], scientific.AuthorizationPatent[11], scientific.AuthorizationPatent[0]]
	        },
	        {
	            name:'申请软著',
	            type:'line',
	            data:[scientific.Applycopyright[11], scientific.Applycopyright[10], scientific.Applycopyright[9], 
	            	scientific.Applycopyright[8], scientific.Applycopyright[7], scientific.Applycopyright[6], 
	            	scientific.Applycopyright[5], scientific.Applycopyright[4], scientific.Applycopyright[3],
	            	scientific.Applycopyright[2], scientific.Applycopyright[1], scientific.Applycopyright[0]]
	        },
	        {
	            name:'授权软著',
	            type:'line',
	            data:[scientific.Authorizationcopyright[11], scientific.Authorizationcopyright[10], scientific.Authorizationcopyright[9], 
	            	scientific.Authorizationcopyright[8], scientific.Authorizationcopyright[7], scientific.Authorizationcopyright[6], 
	            	scientific.Authorizationcopyright[5], scientific.Authorizationcopyright[4], scientific.Authorizationcopyright[3],
	            	scientific.Authorizationcopyright[2], scientific.Authorizationcopyright[1], scientific.Authorizationcopyright[0]]
	        },
	        {
	            name:'受理商标',
	            type:'line',
	            data:[scientific.AgencyTradeMark[11], scientific.AgencyTradeMark[10], scientific.AgencyTradeMark[9], 
	            	scientific.AgencyTradeMark[8], scientific.AgencyTradeMark[7], scientific.AgencyTradeMark[6], 
	            	scientific.AgencyTradeMark[5], scientific.AgencyTradeMark[4], scientific.AgencyTradeMark[3],
	            	scientific.AgencyTradeMark[2], scientific.AgencyTradeMark[1], scientific.AgencyTradeMark[0]]
	        },
	        {
	            name:'授权商标',
	            type:'line',
	            data:[scientific.AuthorizationTradeMark[11], scientific.AuthorizationTradeMark[10], scientific.AuthorizationTradeMark[9], 
	            	scientific.AuthorizationTradeMark[8], scientific.AuthorizationTradeMark[7], scientific.AuthorizationTradeMark[6], 
	            	scientific.AuthorizationTradeMark[5], scientific.AuthorizationTradeMark[4], scientific.AuthorizationTradeMark[3],
	            	scientific.AuthorizationTradeMark[2], scientific.AuthorizationTradeMark[1], scientific.AuthorizationTradeMark[0]]
	        },
	        {
	            name:'论文总数',
	            type:'line',
	            data:[scientific.EachMonththesis[11], scientific.EachMonththesis[10], scientific.EachMonththesis[9], 
	            	scientific.EachMonththesis[8], scientific.EachMonththesis[7], scientific.EachMonththesis[6], 
	            	scientific.EachMonththesis[5], scientific.EachMonththesis[4], scientific.EachMonththesis[3],
	            	scientific.EachMonththesis[2], scientific.EachMonththesis[1], scientific.EachMonththesis[0]]
	        },
	        {
	            name:'著作总数',
	            type:'line',
	            data:[scientific.EachMonthwork[11], scientific.EachMonthwork[10], scientific.EachMonthwork[9], 
	            	scientific.EachMonthwork[8], scientific.EachMonthwork[7], scientific.EachMonthwork[6], 
	            	scientific.EachMonthwork[5], scientific.EachMonthwork[4], scientific.EachMonthwork[3],
	            	scientific.EachMonthwork[2], scientific.EachMonthwork[1], scientific.EachMonthwork[0]]
	        }
	        
	    ]
	};


// 使用刚指定的配置项和数据显示图表。
myChart.setOption(option);

//数据总量
var myChart2 = echarts.init(document.getElementById('totalData'));
var option2 = {
	    tooltip : {
	        trigger: 'axis',
	        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
	            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
	        }
	    },
	    color: ['#ea8a27','#7fccd8', '#3db4e3'],
	    toolbox: {
	        feature: {
	            saveAsImage: {}
	        }
	    },
	    legend: {
	        data: ['外观设计专利', '实用新型专利','发明专利'],
	        textStyle:{    //图例文字的样式
	            color:'#fff',
	            fontSize:12
	        }
	    },
	    grid: {
	        left: '3%',
	        right: '4%',
	        bottom: '3%',
	        containLabel: true
	    },
	    xAxis:  {
	        type: 'category',
	        data: ['申请','受理','授权','驳回'],
	        axisLabel: {
                textStyle: {
                    color: '#3db4e3',
                    fontSize:12
                },
                lineStyle:{ 
                	show: false,
                	color:'#3db4e3' 
                	/*width:8*/
                }
            },
            splitLine: {
                show: false,
                lineStyle: {
                    color: ['#000']
                }
            },
	    },
	    yAxis: {
	        type: 'value',
	        splitLine: {
                show: true,
                lineStyle: {
                    color: ['#3db4e3']
                }
            },
            axisLabel: {
                show: true,
                textStyle: {
                    color: '#3db4e3',
                    fontSize:12
                },
                lineStyle:{ 
                	color:'#3db4e3' 
                	/*width:8*/
                }
            }
	    },
	    series: [
	        {
	            name: '外观设计专利',
	            type: 'bar',
	            barWidth : 30,//柱图宽度
	            stack: '总量',
	            label: {
	                normal: {
	                    /*show: true,*/
	                    position: 'insideRight'
	                }
	            },
	            data: [320, 302, 301, 334]
	        },
	        {
	            name: '实用新型专利',
	            type: 'bar',
	            stack: '总量',
	            label: {
	                normal: {
	                   /* show: true,*/
	                    position: 'insideRight'
	                }
	            },
	            data: [120, 132, 101, 134]
	        },
	        {
	            name: '发明专利',
	            type: 'bar',
	            stack: '总量',
	            label: {
	                normal: {
	                    /*show: true,*/
	                    position: 'insideRight'
	                }
	            },
	            data: [220, 182, 191, 234]
	        }
	    ]
	};

// 使用刚指定的配置项和数据显示图表。
myChart2.setOption(option2);