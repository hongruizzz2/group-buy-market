package com.hongrui.test.domain.tag;

import com.hongrui.domain.tag.service.TagService;
import com.hongrui.infrastructure.redis.IRedisService;
import com.mysql.cj.log.Log;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Result;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RBitSet;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author hongrui
 * @description 人群标签服务测试
 * @date 2025-03-15 15:49
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ITagServiceTest {

    @Resource
    private TagService tagService;
    @Resource
    private IRedisService redisService;

    @Test
    public void test_tag_job() {
        tagService.execTagBatchJob("RQ_KJHKL98UU78H66554GFDV", "10001");
    }

    @Test
    public void test_get_tag_bitmap() {
        RBitSet bitSet = redisService.getBitSet("RQ_KJHKL98UU78H66554GFDV");
        // 是否存在
        log.info("hongrui 存在，预期结果为 true，测试结果:{}", bitSet.get(redisService.getIndexFromUserId("hongrui")));
        log.info("gudebai 不存在，预期结果为 false，测试结果:{}", bitSet.get(redisService.getIndexFromUserId("gudebai")));
    }

    @Test
    public void test_null_tag_bitmap() {
        RBitSet bitSet = redisService.getBitSet("null");
        log.info("测试结果:{}", bitSet.isExists());
    }

}
