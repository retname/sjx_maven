package zy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zy.entity.Options;
import zy.entity.Subject;
import zy.service.SubjectService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by zhangyu on 2017/10/14.
 */
@Controller
public class SubjectController {


    @Resource
    private SubjectService subjectService;

    @ResponseBody
    @RequestMapping("/findAllSubjects.do")
    public Object findAllSubs(){
        List<Subject> all = this.subjectService.findAll();
        return all;
    }


    @RequestMapping("/findAllOpts")
    public String toOpt(Integer id,HttpServletRequest request){
        this.subjectService.doTimes(id);
        List<Subject> all = this.subjectService.findAll();
        for (Subject sut :
                all) {
            if(id==sut.getId()){
                for (Options opts :
                        sut.getOpts()) {
                    System.out.println(opts.getOptContent());
                }
                request.setAttribute("subject",sut);
                request.setAttribute("opts",sut.getOpts());
                break;
            }
        }
        return "opts";
    }

    @RequestMapping("/doVote")
    public String doVote(Integer id,Integer optid,HttpServletRequest request){
       this.subjectService.doVote(id,optid);
        List<Subject> all = this.subjectService.findAll();
        for (Subject sut :
                all) {
            if(id==sut.getId()){
                for (Options opts :
                        sut.getOpts()) {
                    System.out.println(opts.getOptContent());
                }
                request.setAttribute("subject",sut);
                request.setAttribute("opts",sut.getOpts());
                break;
            }
        }
       return "result";
    }


    @RequestMapping("/backone")
    public String backOne(){
        return "index";
    }



}
