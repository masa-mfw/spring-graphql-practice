package com.example.springgraphqlpractice.graphql

import com.example.springgraphqlpractice.graphql.type.ScheduleType
import com.example.springgraphqlpractice.graphql.type.SimpleTask
import com.example.springgraphqlpractice.graphql.type.TaskGroup
import com.example.springgraphqlpractice.graphql.type.TodoType
import com.expediagroup.graphql.generator.scalars.ID
import com.expediagroup.graphql.server.operations.Query
import org.springframework.stereotype.Component

@Component
class ScheduleQuery : Query {
    fun schedule(): ScheduleType {
        val subTask = SimpleTask(
            id = ID("st:1"),
            name = "subTask"
        )
        val taskGroup = TaskGroup(
            id = ID("tg:1"),
            name = "taskGroup",
            tasks = listOf(subTask)
        )
        val otherTask = SimpleTask(
            id = ID("st:2"),
            name = "otherTask"
        )
        val rootTask = TaskGroup(
            id = ID("tg:2"),
            name = "rootTask",
            tasks = listOf(taskGroup, otherTask)
        )
        return ScheduleType(
            id = ID("1"),
            task = rootTask
        )
    }

    fun todo(): TodoType {
        val subTask = SimpleTask(
            id = ID("st:1"),
            name = "subTask"
        )
        val taskGroup = TaskGroup(
            id = ID("tg:1"),
            name = "taskGroup",
            tasks = listOf(subTask)
        )
        val otherTask = SimpleTask(
            id = ID("st:2"),
            name = "otherTask"
        )
        val rootTask = TaskGroup(
            id = ID("tg:2"),
            name = "rootTask",
            tasks = listOf(taskGroup, otherTask)
        )
        return TodoType(
            id = ID("td:1"),
            task = rootTask,
            tasks = listOf(taskGroup),
            isDone = false
        )
    }
}
