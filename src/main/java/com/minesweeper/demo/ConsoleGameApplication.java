package com.minesweeper.demo;

import com.minesweeper.demo.engine.Engine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class ConsoleGameApplication implements CommandLineRunner {
    private static Logger LOG = LoggerFactory
            .getLogger(ConsoleGameApplication.class);

    @Autowired
    private Engine engine;

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ConsoleGameApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        engine.playGame();
        for (int i = 0; i < args.length; ++i){
            LOG.info("args[{}]: {}", i, args[i]);
        }
    }
}

