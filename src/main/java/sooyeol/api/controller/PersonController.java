package sooyeol.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sooyeol.api.base.BaseResult;
import sooyeol.api.model.collection.PersonCollections;
import sooyeol.api.service.PersonService;
import springfox.documentation.annotations.ApiIgnore;
import sooyeol.api.base.BaseController;
import sooyeol.api.model.result.Result;

import javax.websocket.server.PathParam;

@RequiredArgsConstructor
@Controller
@RequestMapping(value = "api/person")
@Api(tags = "테스트")
public class PersonController extends BaseController {

    private final PersonService service;

    @GetMapping("")
    @ApiIgnore
    public String personGet() {
        return "person";
    }

    @PostMapping("")
    @ApiOperation(value = "테스트 입력 API", notes = "테스트 API 입니다.", tags = "테스트")
    public @ResponseBody
    BaseResult personPost(@RequestBody PersonCollections param) {
        BaseResult result = service.insert(param);
        return result;
    }

    @PutMapping("{id}")
    @ApiOperation(value = "테스트 수정 API", notes = "테스트 수정 API 입니다.", tags = "테스트")
    public @ResponseBody
    BaseResult personPut(@PathVariable("id") String id, @RequestBody PersonCollections param) {
        BaseResult result = service.update(id, param);
        return result;
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "테스트 삭제 API", notes = "테스트 삭제 API 입니다.", tags = "테스트")
    public @ResponseBody
    BaseResult personDelete(@PathVariable("id") String id) {
        BaseResult result = service.delete(id);
        return result;
    }

    @DeleteMapping("all")
    @ApiOperation(value = "테스트 잔체 삭제 API", notes = "테스트 전체 삭제 API 입니다.", tags = "테스트")
    public @ResponseBody
    BaseResult personDelete() {
        BaseResult result = service.deleteAll();
        return result;
    }
}
