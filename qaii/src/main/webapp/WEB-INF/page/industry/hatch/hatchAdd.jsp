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
<div class="tool">
	<div class="techadd">
		<img src="${basePath}/image/home.png"  class="home"/>
		<span>首页&nbsp;>&nbsp;</span>
		<span class="blue">孵化企业管理&nbsp;—&nbsp;添加界面</span>
	</div>
	<!--		导出-->
	<button onclick="srchange('hatch.do')" class="layui-btn btn export " style="float: right;margin-right: 115px;margin-top: 12.5px;">
		返回
	</button>		
</div>
<div class="layui-container addtop">
  <form class="layui-form" method="post" action="insertIndustryInfo.do" enctype="multipart/form-data">
  <!-- 基本信息 -->
	  <div class="layui-row contern">
	  	<h1>基本信息</h1>
		<div class="layui-col-xs6 layui-col-md6">
			 <div class="layui-form-item">
			    <label class="layui-form-label">企业名称</label>
			    <div class="layui-input-block">
			      <input type="text" name="companyName" lay-verify="title" autocomplete="off" class="layui-input">
			    </div>
			  </div>
		</div>
	    <div class="layui-col-xs6 layui-col-md6">
			 <div class="layui-form-item">
			    <label class="layui-form-label">统一社会信用代码</label>
			    <div class="layui-input-block">
			      <input type="text" name="creditCode" lay-verify="title" autocomplete="off" class="layui-input">
			    </div>
			  </div>
		</div>
		<div class="layui-col-xs6 layui-col-md6">
			 <div class="layui-form-item">
			    <label class="layui-form-label">成立时间</label>
			    <div class="layui-input-block">
			      <input type="text" name="establishTime" lay-verify="title" autocomplete="off" class="layui-input" id="test1">
			    </div>
			  </div>
		</div>
		<div class="layui-col-xs6 layui-col-md6">
			 <div class="layui-form-item">
			    <label class="layui-form-label">公司类型</label>
			    <div class="layui-input-block">
			      <input type="text" name="companyType" lay-verify="title" autocomplete="off" class="layui-input">
			    </div>
			  </div>
		</div>
		<div class="layui-col-xs6 layui-col-md6">
			 <div class="layui-form-item">
			    <label class="layui-form-label">公司住所</label>
			    <div class="layui-input-block">
			      <input type="text" name="companyLocation" lay-verify="title" autocomplete="off" class="layui-input">
			    </div>
			  </div>
		</div>
		<div class="layui-col-xs6 layui-col-md6">
			 <div class="layui-form-item">
			    <label class="layui-form-label">法定代表人</label>
			    <div class="layui-input-block">
			      <input type="text" name="legalRepresentative" lay-verify="title" autocomplete="off" class="layui-input">
			    </div>
			  </div>
		</div>
		<div class="layui-col-xs6 layui-col-md6">
			 <div class="layui-form-item">
			    <label class="layui-form-label">注册资本</label>
			    <div class="layui-input-block">
			      <input type="text" name="registeredCapital" lay-verify="title" autocomplete="off" class="layui-input">
			    </div>
			  </div>
		</div>
		<div class="layui-col-xs12 layui-col-md12">
			 <div class="layui-form-item">
			    <label class="site-demo-button layui-form-label">经营范围</label>
			    <div class="layui-input-block">
			       <textarea class="layui-textarea" name="businessScope" lay-verify="content" id="LAY_demo_editor"></textarea>
			    </div>
			  </div>
		</div>
		<div class="layui-col-xs6 layui-col-md6">
			 <div class="layui-form-item">
			    <label class="layui-form-label">所属孵化器</label>
			    <div class="layui-input-block">
			      <input type="text" name="incubatorName" lay-verify="title" autocomplete="off" class="layui-input">
			    </div>
			  </div>
		</div>
		<div class="layui-col-xs6 layui-col-md6">
			 <div class="layui-form-item">
			    <label class="layui-form-label">入孵时间</label>
			    <div class="layui-input-block">
			      <input type="text" name="hatchingTime" lay-verify="title" autocomplete="off" class="layui-input" id="test2">
			    </div>
			  </div>
		</div>
		<div class="layui-col-xs6 layui-col-md6">
			 <div class="layui-form-item">
			    <label class="layui-form-label">有限期</label>
			    <div class="layui-input-block">
			      <input type="text" name="limitedPeriod" lay-verify="title" autocomplete="off" class="layui-input" id="test3">
			    </div>
			  </div>
		</div>
		<div class="layui-col-xs6 layui-col-md6">
			<div class="layui-form-item itemadd">
				<label class="layui-form-label">上传营业执照</label>
				<div class="layui-input-block">
					<div class="layui-upload">
					  <button type="button" class="layui-btn layui-btn-normal" id="test10">选择文件</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 创新能力 -->
	<div class="layui-row contern">
	  	<h1>创新能力 </h1>
	  	<div class="layui-col-xs6 layui-col-md6">
	  		<div class="createbox">
				<div class="layui-form-item itemadd">
				    <label class="layui-form-label createlabel" id="isThousandSailEnterprise">是否“千帆计划”入库企业</label>
				    <div class="layui-input-block createblock">
				      <input type="radio" name="isThousandSailEnterprise" value="0" title="否" checked="">
				      <input type="radio" name="isThousandSailEnterprise" value="1" title="是">
				    </div>
				</div>
			</div>
		</div>
		<div class="layui-col-xs6 layui-col-md6">
			<div class="createbox">
				<div class="layui-form-item itemadd">
				    <label class="layui-form-label createlabel" id="isBillionEnterprise">是否入选青岛市科技型企业培育“百千万”工程</label>
				    <div class="layui-input-block createblock">
				      <input type="radio" name="isBillionEnterprise" value="0" title="否" checked="">
				      <input type="radio" name="isBillionEnterprise" value="1" title="是">
				    </div>
				</div>
			</div>
		</div>
		<div class="layui-col-xs6 layui-col-md6">
			<div class="createbox">
				<div class="layui-form-item itemadd">
				    <label class="layui-form-label createlabel">是否高新技术企业</label>
				    <div class="layui-input-block createblock" id="isHighTechnologyEnterprise">
				      <input type="radio" name="isHighTechnologyEnterprise" value="0" title="否" checked="">
				      <input type="radio" name="isHighTechnologyEnterprise" value="1" title="是">
				    </div>
				</div>
				<div class="additionBox" id="isHighTech" style="display:none;">
					<div class="layui-form-item itemadd">
						<label class="layui-form-label">发证时间</label>
					    <div class="layui-input-block">
					      <input type="text" name="certificateTime" lay-verify="title" autocomplete="off" class="layui-input" id="test4">
					    </div>
					</div>
					<div class="layui-form-item itemadd">
						<label class="layui-form-label">证书编号</label>
					    <div class="layui-input-block">
					      <input type="text" name="certificateCode" lay-verify="title" autocomplete="off" class="layui-input">
					    </div>
					</div>
					<div class="layui-form-item itemadd">
						<label class="layui-form-label">发表电子版</label>
						<div class="layui-input-block">
							<div class="layui-upload">
							  <button type="button" class="layui-btn layui-btn-normal" id="test8">选择文件</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="layui-col-xs6 layui-col-md6">
			<div class="createbox">
				<div class="layui-form-item itemadd">
				    <label class="layui-form-label createlabel">是否科技型中小企业</label>
				    <div class="layui-input-block createblock" id="isTechnologyEnterprise">
				      <input type="radio" name="isTechnologyEnterprise" value="0" title="否" checked="">
				      <input type="radio" name="isTechnologyEnterprise" value="1" title="是">
				    </div>
				</div>
				<div class="additionBox" id="isTech" style="display:none;">
					<div class="layui-form-item itemadd">
						<label class="layui-form-label">入库登记编号</label>
					    <div class="layui-input-block">
					      <input type="text" name="incomingRegistrationCode" lay-verify="title" autocomplete="off" class="layui-input">
					    </div>
					</div>
				</div>
			</div>
		</div>
	</div>
    <div class="layui-row">
   	   <div class="layui-col-md12">
		   <div class="layui-form-item">
			<div class="layui-input-block" style="text-align: right;">
			  <button class="layui-btn" lay-submit="" lay-filter="demo1" onSubmit="imgjudge()">立即提交</button>
			  <button type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		  </div>
  		</div>
  	</div>
 </form>
</div>
<script src="${basePath}/commen/layui/layui.js"></script>
<script>
layui.use(['layer','form', 'layedit', 'laydate','element','upload','table'], function(){
  var form = layui.form,
	element = layui.element,
	layer = layui.layer,
	laydate = layui.laydate,
	upload = layui.upload,
    table = layui.table;
	//日期
	 laydate.render({
	   	elem: '#test1'
	  });
	//日期
	 laydate.render({
	   	elem: '#test2'
	  });
	//日期
	 laydate.render({
	   	elem: '#test3'
	  });
	//日期
	 laydate.render({
	   	elem: '#test4'
	  });
//文件上传发表电子版
 upload.render({
   elem: '#test8'
   ,url: '/upload/'
   ,auto: false
   ,accept: 'file' //普通文件
   ,bindAction: '#test9'
   ,done: function(res){
     console.log(res)
   }
 });
//文件上传营业执照
 upload.render({
   elem: '#test10'
   ,url: '/upload/'
   ,auto: false
   ,accept: 'file' //普通文件
   ,bindAction: '#test11'
   ,done: function(res){
     console.log(res)
   }
 });
});
/**根据选择框显示隐藏内容**/
 /* 高新技术企业 */
$('#isHighTechnologyEnterprise').click(function(){
	var s=$('input[name="isHighTechnologyEnterprise"]:checked ').val();
	if(s==1){
		$("#isHighTech").show();
	}else{
		$("#isHighTech").hide();
	}
})
/*科技中小型企业*/
$('#isTechnologyEnterprise').click(function(){
	var s=$('input[name="isTechnologyEnterprise"]:checked ').val();
	if(s==1){
		$("#isTech").show();
	}else{
		$("#isTech").hide();
	}
})

</script>
<script src="${basePath}/js/iframesrc.js"></script>
</body>
</html>