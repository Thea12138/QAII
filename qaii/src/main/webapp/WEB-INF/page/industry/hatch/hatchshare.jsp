<!DOCTYPE html>
<html>
<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>科研成果管理系统</title>
 <link rel="shortcut icon" type="image/x-icon" href="${basePath}/image/icon.ico" media="screen" />
  <link rel="stylesheet" href="${basePath}/commen/layui/css/layui.css" media="all" />
  <link rel="stylesheet" href="${basePath}/commen/layui/css/layuiAdd.css" media="all" />
  <link rel="stylesheet" href="${basePath}/commen/layui/css/style.css">
  <link rel="stylesheet" href="${basePath}/commen/layui/css/science.css" media="all" />
  <link rel="stylesheet" href="${basePath}/css/industry.css" media="all" />
  <script src="${basePath}/js/jquery-3.3.1.min.js"></script>
  <style>
    body{margin: 10px;}
  </style>
</head>
<body id="bodyHei">
    <table class="layui-hide" id="table2" lay-filter="demo2"></table>
    <script type="text/html" id="barDemo2">
  		<a class="layui-btn layui-btn-edit layui-btn-xs" lay-event="edit">变更时间修改</a>
	</script>
<script src="${basePath}/commen/layui/layui.js"></script>
<script>
layui.use(['layer','form', 'layedit', 'laydate','element','upload','table'], function(){
  var layer = layui.layer,
	laydate = layui.laydate,
    table = layui.table;
//变更信息显示
  table.render({
	    elem: '#table2'
	    /* ,url:'/demo/table/user/' */ /*back 变更信息数据接口 删除data*/
	    ,cellMinWidth: 100
	    ,cols: [[
	      {field:'id', title: '序号',type:'numbers',sort: true, minWidth: 100}
	      ,{field:'username', title: '变更时间'}
	      ,{field:'username', title: '变更记录'}
	      ,{fixed: 'right', width:178, align:'center', toolbar: '#barDemo2'}
	    ]],
	    data: [{
	        "id": "10001"
	        ,"username": "杜甫"
	      }, {
        	"id": "10008"
            ,"username": "贤心"
          }]
	  });
  table.on('tool(demo2)', function(obj){
	    var data = obj.data;
	   if(obj.event === 'edit'){
		   layer.open({
	    		  type: 2, 
	    		  shade: false, //不显示遮罩
	    		  title:'变更时间修改',
	    		  content: 'hatchchangetime.do',
	 		      area: ['390px', '380px']
	    		});
	    }
	  });
});
</script>
</body>
</html>