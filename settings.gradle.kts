rootProject.name = "dreamStore"

include("common", "common:domain", "common:data",
        "product","product:domain", "product:usecase", "product:data",
        "member", "member:domain", "member:usecase", "member:data",
        "data", "order:domain", "order:usecase", "order:data",
        "application", "application:fornt",
)
