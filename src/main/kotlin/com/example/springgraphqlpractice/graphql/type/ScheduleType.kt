package com.example.springgraphqlpractice.graphql.type

import com.expediagroup.graphql.generator.annotations.GraphQLName
import com.expediagroup.graphql.generator.annotations.GraphQLType
import com.expediagroup.graphql.generator.annotations.GraphQLUnion
import com.expediagroup.graphql.generator.scalars.ID

data class ScheduleType(
    val id: ID,
    val task: Task,
)
