rootProject.name = "dreamStore"

include("common",
        "domain","domain:product",
        "api","api:product",
        "data", "data:product",
        "usecase","usecase:product")