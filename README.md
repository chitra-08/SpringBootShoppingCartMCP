# SpringBootShoppingCartMCP

**Spring Boot MCP Server – Conversational Shopping Cart Application**

This project implements a **conversational shopping cart backend** using **Spring Boot** and **Model Context Protocol (MCP)**. It provides backend tools for adding, removing, updating, and listing cart items, designed to be invoked by AI assistants or other MCP clients.

---

## 🧠 Overview

The goal of this project is to expose shopping cart operations as tools that can be called programmatically via the **Model Context Protocol (MCP)**. This enables conversational interfaces (for example, chat-based assistants) to interact with the shopping cart backend in a structured and reliable way.

---

## 🚀 Features

- Add items to the shopping cart
- Remove items from the cart
- Update item quantities
- List all cart items
- Expose shopping cart operations as MCP tools
- JSON-RPC based communication

---

## 🧱 Technology Stack

- Java 17+
- Spring Boot
- Spring Data JPA
- Model Context Protocol (MCP)
- JSON-RPC
- Maven

---

## 🛠️ Getting Started

### Prerequisites

Ensure you have the following installed:

- Java 17 or later
- Maven 3.8+
- A database (MySQL / H2 / PostgreSQL)

---

## 📦 Installation

1. Clone the repository

git clone https://github.com/chitra-08/SpringBootShoppingCartMCP.git


---


### 🚀 How to use it as MCP Server in the MCP Host like Claude Desktop

1. Open the claude desktop and go to settings. Open Developer settings and go to Local MCP Servers -> Choose Edit Config
2. Provide the MCP server details like below:
{
  "mcpServers": {
    "shopping-cart-server": {
      "command": "java",
      "args": [
        "-jar",
        "E:\SpringBootMCPServer\ShoppingCartMCPServerNew.jar"
      ]
    }
  }
}
3. After saving teh config file, Quit the claude desktop and open it again. Your MCP server is ready-to-use.


---


<img width="2878" height="1704" alt="image" src="https://github.com/user-attachments/assets/645be590-17ed-4e42-8e14-0c5e9eea3aaf" />
<img width="2879" height="1701" alt="image" src="https://github.com/user-attachments/assets/fe58f77f-419e-4722-a9ba-2dd1778f3c3a" />
<img width="2879" height="1702" alt="image" src="https://github.com/user-attachments/assets/7cd40433-4703-46fd-bdbd-eb9fc380e040" />
<img width="1381" height="338" alt="image" src="https://github.com/user-attachments/assets/761763bd-af52-48e7-806e-4718680926fb" />



