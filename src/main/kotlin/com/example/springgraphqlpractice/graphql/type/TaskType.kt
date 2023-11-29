package com.example.springgraphqlpractice.graphql.type

import com.expediagroup.graphql.generator.annotations.GraphQLName
import com.expediagroup.graphql.generator.annotations.GraphQLUnion
import com.expediagroup.graphql.generator.scalars.ID

interface TaskType {
    val id: ID
    val name: String
}

data class SimpleTaskType(
    override val id: ID,
    override val name: String,
) : TaskType

data class TaskGroupType(
    override val id: ID,
    override val name: String,
    @GraphQLUnion(
        name = "Task",
        possibleTypes = [
            SimpleTaskType::class,
            TaskGroupType::class
        ]
    )
    val tasks: List<Any>,
) : TaskType
