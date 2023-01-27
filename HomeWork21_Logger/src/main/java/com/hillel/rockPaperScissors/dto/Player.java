package com.hillel.rockPaperScissors.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Player {
    private String name;
    private int hand;
    private Integer numberOfGames = 0;
    private Integer numberOfLose = 0;
    private Integer numberOfWinGames = 0;

}
