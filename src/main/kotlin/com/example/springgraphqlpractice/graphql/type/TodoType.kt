package com.example.springgraphqlpractice.graphql.type

import com.expediagroup.graphql.generator.annotations.GraphQLType
import com.expediagroup.graphql.generator.annotations.GraphQLUnion
import com.expediagroup.graphql.generator.scalars.ID

data class TodoType(
    val id: ID,
    val task: Task,
    val tasks: List<Task>,
    val isDone: Boolean,
)
