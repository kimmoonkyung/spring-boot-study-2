package com.example.mycontact.repository;

import com.example.mycontact.domain.Block;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class BlockRepositoryTest {

    @Autowired
    private BlockRepository blockRepository;

    @Test
    void crud() {
        Block block = Block.builder()
                .name("짐승균")
                .reason("짐승내와내연애")
                .startDate(LocalDate.now())
                .endDate(LocalDate.now())
                .build();

        blockRepository.save(block);

        List<Block> blockList = blockRepository.findAll();

        Assertions.assertEquals(blockList.size(), 1);
        Assertions.assertEquals(blockList.get(0).getName(), "짐승균");
    }

}