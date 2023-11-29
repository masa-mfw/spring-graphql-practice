package com.example.springgraphqlpractice.graphql

import com.example.springgraphqlpractice.graphql.type.ScheduleType
import com.example.springgraphqlpractice.graphql.type.SimpleTaskType
import com.example.springgraphqlpractice.graphql.type.TaskGroupType
import com.expediagroup.graphql.generator.scalars.ID
import com.expediagroup.graphql.server.operations.Query
import org.springframework.stereotype.Component

@Component
class ScheduleQuery : Query {
    fun schedule(): ScheduleType {
        val subTask = SimpleTaskType(
            id = ID("st:1"),
            name = "subTask"
        )
        val taskGroup = TaskGroupType(
            id = ID("tg:1"),
            name = "taskGroup",
            tasks = listOf(subTask)
        )
        val otherTask = SimpleTaskType(
            id = ID("st:2"),
            name = "otherTask"
        )
        val rootTask = TaskGroupType(
            id = ID("tg:2"),
            name = "rootTask",
            tasks = listOf(taskGroup, otherTask)
        )
        return ScheduleType(
            id = ID("1"),
            task = rootTask
        )
    }
}
