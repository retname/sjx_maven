package com.controller;

import com.pojo.Itemtypes;
import com.pojo.Peitems;
import com.service.ItemtypesService;
import com.service.PeitemsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by zhangyu on 2017/10/18.
 */
@Controller
public class ItemtypesController {




    @Resource
    private ItemtypesService itemtypesService;

    @Resource
    private PeitemsService peitemsService;



    @RequestMapping("/getalltypes")
    public String getAllItemTypes(HttpServletRequest request){
        List<Itemtypes> all = this.itemtypesService.getAll();
        request.setAttribute("itemtypes",all);
        return "1";

    }


    @RequestMapping("/getAllPeitems")
    public String getAllPeitems(HttpServletRequest request){
        List<Itemtypes> all = this.itemtypesService.getAll();
        request.setAttribute("itemtypes",all);
        Integer id= Integer.parseInt(request.getParameter("myselect"));
        for (Itemtypes item :
                all) {
            if(id==item.getTypeid()){
                request.setAttribute("selected",item);
                request.setAttribute("allpeitems",item.getPeitems());
                break;
            }
        }
        return "1";
    }

    @RequestMapping("/forupdate")
    public String forUpdate(HttpServletRequest request){
        Integer id=Integer.parseInt(request.getParameter("typeid").substring(0,1).trim());   //项目id

        List<Itemtypes> all = this.itemtypesService.getAll();
        request.setAttribute("itemtypes",all);

        Peitems peitemsById = this.peitemsService.getPeitemsById(id);
        request.setAttribute("peitems",peitemsById);

        return "forupdate";
    }


    @RequestMapping("/doUpdate")
    public String doUpdate(Peitems peitems,HttpServletRequest request){
        System.out.println(peitems.getNecessary());
        System.out.println(request.getParameter("myselect"));
        if(peitems.getNecessary()==null){
            peitems.setNecessary(0);
        }
        Itemtypes myselect = this.itemtypesService.getItemtypesById(Integer.parseInt(request.getParameter("myselect").trim()));
        peitems.setItemtypes(myselect);
        this.peitemsService.saveOrUpdate(peitems);
        return "index";
    }




}
