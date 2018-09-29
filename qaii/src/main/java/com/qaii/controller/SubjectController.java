package com.qaii.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.qaii.domain.Govsubject;
import com.qaii.domain.Govsubject;
import com.qaii.service.GovSubjectService;
import com.qaii.util.AlertException;
import com.qaii.util.CustomException;
import com.qaii.util.JsonResult;
import com.qaii.util.Layui;

@Controller
public class SubjectController {
	
	@Resource
	private GovSubjectService govsubjectService;
	//获取所有政府项目信息
	@RequestMapping(value="getAllSubjectMsg.do",method=RequestMethod.POST)
	@ResponseBody
	public Layui getAllSubjectMsg() {
		List<Govsubject> result=govsubjectService.getAllSubjectMsg();
//			for(Govsubject govsubjectware:result) {
//				CountDatetoNowDays.TranstoDate(emp);
//			}
		int count =result.size();
		if(result!=null) {
			return Layui.data(count, result);
		}else {
			return Layui.data(count, result);
		}
	}
	//删除政府项目信息
	@RequestMapping("dellSubjectMsg.do")
	@ResponseBody
	public JsonResult dellSubjectMsg(@RequestParam("requestDate[]") Integer[] eid){
		int row=govsubjectService.deleteMsg(eid);
    	if(row!=0) {
    		return  new JsonResult(row);
    	}else {
    		return  new JsonResult();
    		
    	}
	}
	
	//跳转到政府项目详情页面
	@RequestMapping("toGovsubjectDetails.do")
	public String toGovsubjectDetail() {
		
		return "page/science/";
	}
	
	//政府项目查看详情
	@RequestMapping(value="showGovsubjectDetails.do",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult showGovsubjectDetails(Govsubject govsubject,HttpServletRequest req) {	
		
		int userid=Integer.parseInt(req.getParameter("userId"));
		//Govsubject.setId();
		govsubject = govsubjectService.selectByPrimaryKey(userid);
		return new JsonResult(govsubject);
	}
	
	//跳转到修改政府项目详情页面
	@RequestMapping("UpdateGovsubject.do")
	public String toUpdateGovsubject() {
		return "page/science";
	}
	
	//修改政府项目信息功能
	@RequestMapping(value="updateGovsubject.do", method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	public String updateGovsubjects(Govsubject govsubject,HttpServletRequest req){	
		loadData(req, govsubject);
		int row =govsubjectService.updateMsg(govsubject);
		if(row>=1) {
			//String data="更新成功";
			 return "page/science/add-succesd";
		}else {
			return "page/science/add-faild";
			//return new JsonResult();
		}
	}
	//绑定请求数据到bean中
	void loadData(HttpServletRequest req,Govsubject govsubject){
		govsubject.setGovsubApplytime(req.getParameter("govsubApplytime"));
		govsubject.setGovsubSource(req.getParameter("govsubSource"));
		govsubject.setGovsubLevel(req.getParameter("govsubLevel"));
		govsubject.setGovsubName(req.getParameter("govsubName"));
		govsubject.setGovsubImplementtime(req.getParameter("govsubImplementtime"));
		govsubject.setGovsubDutyunit(req.getParameter("govsubDutyunit"));
		govsubject.setGovsubCooperationunit(req.getParameter("govsubCooperationunit"));
		govsubject.setGovsubManagedepart(req.getParameter("govsubManagedepart"));
		govsubject.setGovsubApplydepart(req.getParameter("govsubApplydepart"));
		govsubject.setGovsubAssumedepart(req.getParameter("govsubAssumedepart"));
		govsubject.setGovsubProjectper(req.getParameter("govsubProjectper"));
		govsubject.setGovsubProjectapproval(req.getParameter("govsubProjectapproval"));
		govsubject.setGovsubApprovalnum(req.getParameter("govsubApprovalnum"));
		govsubject.setGovsubSubvention(req.getParameter("govsubSubvention"));
		govsubject.setGovsubFundtime(req.getParameter("govsubFundtime"));
		govsubject.setGovsubMiddleresult(req.getParameter("govsubMiddleresult"));
		govsubject.setGovsubYearresult(req.getParameter("govsubYearresult"));
		govsubject.setGovsubEndresult(req.getParameter("govsubEndresult"));
		govsubject.setGovsubRemark(req.getParameter("govsubRemark"));
		govsubject.setGovsubFile(req.getParameter("govsubFile"));
	}
	//添加政府项目信息功能
	@RequestMapping("addGovsubject.do")
	public String AddGovsubject(HttpServletRequest req,Govsubject govsubject) {
		loadData(req, govsubject);		
		int row = govsubjectService.insertMsg(govsubject);
		if(row>0) {
//						Map<String,String> map=new HashMap<>();
//						 map.put("url","intoPerSys.do");
//						 map.put("data", "提交成功");
			 
			//return new JsonResult();
			 return "page/science/add-succesd";
		}else {
			return "page/science/add-faild";
			//return new JsonResult();
		}
		
	}
	
	//使用excel文件快捷导入政府项目数据
	@RequestMapping(value="insertGovsubjectDatabyexcel.do")
	@ResponseBody
	public Layui test(@RequestParam("file")MultipartFile file) throws FileNotFoundException, IOException, CustomException, AlertException  {
		Layui result = null;
		List<String> list =new ArrayList<>();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String filename=file.getOriginalFilename();
		Workbook wookbook;
		//判断是不是excel文件
		if(!(filename.endsWith(".xls")||filename.endsWith(".xlsx")))
			throw new AlertException("请选择excel格式的文件！");
		//判断是03版还是07版excel
		if(filename.endsWith(".xls")) {
			wookbook=new HSSFWorkbook(file.getInputStream());
		}else {
			wookbook=new XSSFWorkbook(file.getInputStream());
		}
		try {
			Sheet sheet=wookbook.getSheet("Sheet1");
			int rows = sheet.getPhysicalNumberOfRows();
			for (int i=1;i<rows;i++) {
				Row row =sheet.getRow(i);
				int cells=sheet.getRow(0).getPhysicalNumberOfCells();
				if (row!=null) {
					list.clear();
					for (int j=0;j<cells;j++) {
						Cell cell=row.getCell(j);
						if(cell!=null){
							int cellType=cell.getCellType();
							switch(cellType) {
								case Cell.CELL_TYPE_BLANK: 	//单元格式为空白
									cell.setCellType(Cell.CELL_TYPE_STRING);
									break;
								case Cell.CELL_TYPE_BOOLEAN: //布尔
									cell.setCellType(Cell.CELL_TYPE_BOOLEAN);
									break;
								case Cell.CELL_TYPE_ERROR: 	//错误
									cell.setCellValue("错误");
									break;
								case Cell.CELL_TYPE_FORMULA: //公式
									cell.setCellType(Cell.CELL_TYPE_STRING);
									break;
								case Cell.CELL_TYPE_NUMERIC: 	//日期、数字
									if (DateUtil.isCellDateFormatted(cell))
										cell.setCellValue(sdf.format(cell.getDateCellValue()));
									else {
										cell.setCellType(Cell.CELL_TYPE_STRING);
									}
									break;
								case Cell.CELL_TYPE_STRING:		//文本
									cell.setCellType(Cell.CELL_TYPE_STRING);
							}
							list.add(cell.toString());
						}else {
							list.add(null);
						}
					}
					Govsubject govsubject = new Govsubject();
					govsubject=setGovsubjectvalue(govsubject, list);
					if(govsubject.getGovsubApplytime()!=null)
						govsubject.setGovsubApplytime(govsubject.getGovsubApplytime().replace("/", "-"));
					if(govsubject.getGovsubImplementtime()!=null)
						govsubject.setGovsubImplementtime(govsubject.getGovsubImplementtime().replace("/", "-"));
					if(govsubject.getGovsubFundtime()!=null)
						govsubject.setGovsubFundtime(govsubject.getGovsubFundtime().replace("/", "-"));
					govsubjectService.insertMsg(govsubject);
					result=result.data(1, null);
					
				}
			}
		}catch(Exception e) {
			wookbook.close();
			e.printStackTrace();
			throw new CustomException("数据库异常!请检查文件格式!");			
		}
		wookbook.close();
		return result;
		
	}
	public Govsubject setGovsubjectvalue(Govsubject govsubject,List<String> value) {
		govsubject.setGovsubApplytime(value.get(0));
		govsubject.setGovsubSource(value.get(1));
		govsubject.setGovsubLevel(value.get(2));
		govsubject.setGovsubName(value.get(3));
		govsubject.setGovsubImplementtime(value.get(4));
		govsubject.setGovsubDutyunit(value.get(5));
		govsubject.setGovsubCooperationunit(value.get(6));
		govsubject.setGovsubManagedepart(value.get(7));
		govsubject.setGovsubApplydepart(value.get(8));
		govsubject.setGovsubAssumedepart(value.get(9));
		govsubject.setGovsubProjectper(value.get(10));
		govsubject.setGovsubProjectapproval(value.get(11));
		govsubject.setGovsubApprovalnum(value.get(12));
		govsubject.setGovsubSubvention(value.get(13));
		govsubject.setGovsubFundtime(value.get(14));
		govsubject.setGovsubMiddleresult(value.get(15));
		govsubject.setGovsubYearresult(value.get(16));
		govsubject.setGovsubEndresult(value.get(17));
		govsubject.setGovsubRemark(value.get(18));
		govsubject.setGovsubFile(value.get(19));
		
		return govsubject;
	}

}