package com.hillel.rockPaperScissors.dto;

import lombok.Data;
import lombok.experimental.Accessors;

    @Data
    @Accessors(chain = true)
    public class Computer {
        private int hand;
}
