rootProject.name = "dreamStore"

include("domain","domain:product", "domain:member",
        "data", "data:common", "data:product",
        "usecase","usecase:product",
        "api","api:product",)