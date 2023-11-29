package com.example.springgraphqlpractice.graphql.type

import com.expediagroup.graphql.generator.annotations.GraphQLName
import com.expediagroup.graphql.generator.annotations.GraphQLUnion
import com.expediagroup.graphql.generator.scalars.ID

data class ScheduleType(
    val id: ID,
    @GraphQLUnion(
        // if you comment out this line instead of TaskGroup, the error will disappear
        // name = "Task",
        name = "UnitedTask",
        possibleTypes = [
            SimpleTaskType::class,
            TaskGroupType::class
        ]
    )
    val task: Any,
)
