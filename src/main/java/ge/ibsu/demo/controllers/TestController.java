package ge.ibsu.demo.controllers;
import ge.ibsu.demo.dto.TestPersonInfo;
import org.springframework.web.bind.annotation.*;

import ge.ibsu.demo.dto.TestPerson;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @GetMapping("/hi")
    public String sayHi() {
        return "Hello From Server";
    }

    @PostMapping("/call")
    public TestPerson call(@RequestBody TestPerson p) {
        p.setFirstName(p.getFirstName() + " from server");
        return p;
    }

    @PostMapping("/testRecords")
    public TestPersonInfo testCallRecord(@RequestBody TestPersonInfo p) {
        System.out.println(p.firstName() + " " + p.lastName() + " " + p.age());
        return p.withAge(30);
    }
}
