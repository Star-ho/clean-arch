rootProject.name = "dreamStore"

include("domain", "domain:common", "domain:product", "domain:member", "domain:order",
        "usecase","usecase:product","usecase:member", "usecase:order",
        "data", "data:common", "data:product", "data:member", "data:order",
        "api","api:console"
)
