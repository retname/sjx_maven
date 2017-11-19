package cn.tms.controller;

import cn.tms.entity.News;
import cn.tms.entity.UserInfo;
import cn.tms.service.INewsService;
import cn.tms.service.IUserInfoService;
import com.alibaba.fastjson.JSONObject;


import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.registry.infomodel.User;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangyu on 2017/11/8.
 */
@Controller
public class NewsController {


    @Resource
    private INewsService  iNewsService;

    @Resource
    private IUserInfoService iUserInfoService;







    @ResponseBody
    @RequestMapping("findAllNews")
    public  Object getAllNewsByColumn(HttpServletResponse response,HttpServletRequest request,
                                      Integer syscolumn, String page, String rows,String cname,Integer state) throws IOException {

        UserInfo userInfo= (UserInfo)request.getSession().getAttribute("userinfo");

        int currentpage = Integer.parseInt((page == null || page == "0") ? "1": page);//第几页
        int pagesize = Integer.parseInt((rows == null || rows == "0") ? "2": rows);//每页多少行
        currentpage  = (currentpage-1)*pagesize;

        Map<String,Object> maps = new HashMap<String, Object>();
        maps.put("syscolumn",syscolumn);
        maps.put("currentpage",currentpage);
        maps.put("pagesize",pagesize);
        maps.put("userid",this.iUserInfoService.getUserIdByUserName(userInfo.getUsername()));
        if(cname!=null&&cname.equals("")){
            maps.put("cname",cname.trim());
        }
        if(state!=null){
            maps.put("state",state);
        }
        List<News> allNews = this.iNewsService.getAllNews(maps);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("total",this.iNewsService.getNewSize(maps));
        jsonObject.put("rows",allNews);
        response.getWriter().write(jsonObject.toString());//转化为JSOn格式
        return null;
    }


    @ResponseBody
    @RequestMapping("/deleNews")
    public String delNews(Integer id){
        if(id==null||id.equals("")){
            return "瞎xx访问";
        }
        System.out.println("执行删除");
        this.iNewsService.delNews(id);
        return "y";
    }

    @RequestMapping("/doAddColumn")
    public String toAddColumn(){
        return "addColumnDetail";
    }







    @RequestMapping(value = "/doAddNews",method = RequestMethod.GET)
    public String addNewsByGet(){
        return "/doAddNews";
    }

    @RequestMapping(value = "/doAddNews",method = RequestMethod.POST)
    public String addNews(News news, MultipartFile fileUp,Integer sys_state, HttpServletRequest request)  {
        UserInfo userInfo = (UserInfo) request.getSession().getAttribute("userinfo");
        Integer userIdByUserName = this.iUserInfoService.getUserIdByUserName(userInfo.getUsername());
        String realPath = request.getSession().getServletContext().getRealPath("/static/images");


        if(news.getSys_id()!=null){

            System.out.println("执行更改操作");

            news.setSys_uptime(new Date());
            news.setSys_state(sys_state);
            news.setSys_admin(userIdByUserName);
            File file = new File(realPath,fileUp.getOriginalFilename());
            news.setSys_file("/static/images"+fileUp.getOriginalFilename());
            if(file!=null){
                try {
                    this.iNewsService.upNewsById(news);
                    fileUp.transferTo(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return "content";
            }else{
                return "error/error";
            }


        }else{


            news.setSys_uptime(new Date());
            news.setSys_state(sys_state);
            news.setSys_admin(userIdByUserName);
            //设置文件上传的路径

            File file = new File(realPath,fileUp.getOriginalFilename());
            news.setSys_file("/static/images"+fileUp.getOriginalFilename());
            if(file!=null){
                try {
                    this.iNewsService.doAddNews(news);
                    fileUp.transferTo(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return "content";
            }else{
                return "error/error";
            }
        }


    }



    @ResponseBody
    @RequestMapping("/getid")
    public Object getJump(Integer id){
        System.out.println(id);
        News newsById = this.iNewsService.getNewsById(id);
        System.out.println(newsById.getSys_content()+"----");
        return newsById;
    }


}
