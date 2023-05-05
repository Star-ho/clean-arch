rootProject.name = "hexagonal-test"

include(
    "common", "common:domain", "common:data",
    "product", "product:domain", "product:data",
    "member", "member:domain", "member:data",
    "order", "order:domain", "order:data",
    "application", "application:api",
)
