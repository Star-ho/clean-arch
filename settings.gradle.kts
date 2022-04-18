rootProject.name = "dreamStore"

include("domain", "domain:common", "domain:product", "domain:member",
        "data", "data:common", "data:product", "data:member",
        "usecase","usecase:product","usecase:member",
        "api","api:product","api:member",)