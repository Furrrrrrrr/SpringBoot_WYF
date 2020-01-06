package com.vash.highlight_spring4.ch1.di;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 此处用@Component也可以
 */
@Configuration
@ComponentScan("com.vash.highlight_spring4.ch1.di")
public class DiConfig {
}
