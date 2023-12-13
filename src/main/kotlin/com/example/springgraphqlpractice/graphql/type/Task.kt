package com.example.springgraphqlpractice.graphql.type

import com.expediagroup.graphql.generator.scalars.ID

interface Task

data class SimpleTask(
    val id: ID,
    val name: String,
) : Task

data class TaskGroup(
    val id: ID,
    val name: String,
    val tasks: List<Task>,
) : Task
