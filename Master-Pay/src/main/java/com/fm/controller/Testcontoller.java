package com.fm.controller;


import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.fm.common.ResultBase;
import com.fm.common.ResultData;
import com.fm.common.ResultQuery;
import com.fm.service.Userservice;
import com.fm.utils.GenerateNumberUtil;
import com.fm.utils.PageUtil;
import com.fm.utils.judgeNull;
import com.github.pagehelper.PageHelper;

@Controller
@RequestMapping(value="test")
public class Testcontoller {
	@Autowired
	private Userservice userservice;
	
	

	
	
	
	
	
}
