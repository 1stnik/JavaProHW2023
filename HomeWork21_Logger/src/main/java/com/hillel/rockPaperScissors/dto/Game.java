package com.hillel.rockPaperScissors.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Game {

    private Player player;
    private Computer computer;
}
