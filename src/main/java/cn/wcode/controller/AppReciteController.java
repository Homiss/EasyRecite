package cn.wcode.controller;

import cn.wcode.dto.ReciteQuestionDto;
import cn.wcode.dto.Result;
import cn.wcode.model.Question;
import cn.wcode.model.ReciteRecord;
import cn.wcode.model.Setting;
import cn.wcode.service.QuestionService;
import cn.wcode.service.ReciteRecordService;
import cn.wcode.service.SettingService;
import cn.wcode.service.UserService;
import com.github.pagehelper.PageInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by homiss on 2017/6/8.
 */

@RestController
@RequestMapping("/api/app/recite")
public class AppReciteController {

  @Autowired
  private ReciteRecordService reciteRecordService;
  @Autowired
  private SettingService settingService;

  /**
   * 获取需要背诵的题目列表
   * @param reciteRecord
   * @return
   */
  @RequestMapping("/v1/today/task")
  @ResponseBody
  public Result<PageInfo<ReciteQuestionDto>> selectTodayTask(ReciteRecord reciteRecord) {
    Setting setting = settingService.selectByUserId(reciteRecord.getUserId());
    reciteRecord.setRows(setting.getReciteNum() != null ? setting.getReciteNum() : 20);
    List<ReciteQuestionDto> reciteRecordList = reciteRecordService.selectTodayTask(reciteRecord);
    return new Result<>(new PageInfo<>(reciteRecordList));
  }

  /**
   * 修改已背单条记录
   * status : -1,完全记得，当前题目不再出现 0, 不记得 1，记得
   */
  @RequestMapping(value = "/v1/modify/record", method = RequestMethod.POST)
  @ResponseBody
  public Result<String> modifyRecord(int id, int status){
    reciteRecordService.modifyReciteRecord(id, status);
    return new Result<>("更新记录成功～");
  }

  /**
   * 获取已完成的题目列表
   */
  @RequestMapping(value = "/v1/finish/record", method = RequestMethod.POST)
  @ResponseBody
  public Result<List<Map<String, String>>> finishRecord(@RequestParam("userId") int userId){
    List<Map<String, String>> records = reciteRecordService.selectHasReciteRecord(userId);
    List<String> demo = new Vector<>();
    return new Result<>(records);
  }


}
