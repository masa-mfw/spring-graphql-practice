package com.example.springgraphqlpractice.graphql.type

import com.expediagroup.graphql.generator.annotations.GraphQLUnion
import com.expediagroup.graphql.generator.scalars.ID

data class TodoType(
    val id: ID,
    @GraphQLUnion(
        name = "UnitedTask",
        possibleTypes = [
            SimpleTaskType::class,
            TaskGroupType::class
        ]
    )
    val task: Any,
    @GraphQLUnion(
        name = "UnitedTask",
        possibleTypes = [
            SimpleTaskType::class,
            TaskGroupType::class
        ]
    )
    val tasks: List<Any>,
    val isDone: Boolean,
)
