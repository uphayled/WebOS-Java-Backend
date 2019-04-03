package WindowsOut;

import java.util.Map;

import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.net.SyslogOutputStream;
import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@CrossOrigin
@RestController
@RequestMapping("/request")
public class RequestController {

    @CrossOrigin
    @RequestMapping("/dir")
    public String String(@RequestParam(value="loc") String loc) {
        Gson gson = new Gson();
        Request r = new Request(loc);

        try {
            //System.out.println(r.getLocation());
            return r.getResults();
        }catch(Exception e){
            System.out.println(e);
        }
        return r.basecase;
    }
    /*public String String(@RequestParam(value="data") String obj) {
        Gson gson = new Gson();
        Request r = gson.fromJson(obj,Request.class);
        try {
            //System.out.println(r.getLocation());
            return r.getDir();
        }catch(Exception e){
            System.out.println(e);
        }
        return r.basecase;
    }*/






}
