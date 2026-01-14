package com.mcp.project.ShoppingCartMCPServer;

import com.mcp.project.ShoppingCartMCPServer.tools.ShoppingCartMCPService;
import org.springframework.ai.support.ToolCallbacks;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ShoppingCartMcpServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingCartMcpServerApplication.class, args);
	}

	@Bean
	public List<ToolCallback> shoppingCartToolCallBack(ShoppingCartMCPService mcpService){
			return List.of(ToolCallbacks.from(mcpService));
	}

}
