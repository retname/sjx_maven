package cn.tms.controller;

import cn.tms.dao.IStateDao;
import cn.tms.entity.Content;
import cn.tms.entity.State;
import cn.tms.service.IContentService;
import cn.tms.service.IStateService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangyu on 2017/11/7.
 */
@Controller
public class ContentController {

    @Resource
    private IContentService iContentService;

    @Resource
    private IStateService iStateService;

    @ResponseBody
    @RequestMapping("getAllContent")
    public Object getAllConts(HttpServletRequest request){
        List<Content> rootMenus = new ArrayList<Content>();   //一级菜单集合
        List<Content> childList = this.iContentService.findAllContent();
        for (Content item:childList){
            Content childMenu=item;
            int c_id = childMenu.getC_parent();
            if (c_id==0){
                rootMenus.add(item);
            }else{
                for (Content innerMenu:childList){
                    Integer id = innerMenu.getC_id();
                    if (id==c_id){
                        Content parentMenu=innerMenu;
                        parentMenu.getChildren().add(childMenu);
                        break;
                    }
                }
            }
        }

        return rootMenus;
    }



    @ResponseBody
    @RequestMapping("getContentForCMB")
    public Object  getContetnForCMB(){
        List<Content> contentForCmb = this.iContentService.findContentForCmb();
        return contentForCmb;
    }



}
