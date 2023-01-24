package DataStructures_and_Algorithms.Graphs

import DataStructures_and_Algorithms.Graphs.Vertex

data class Edge<T>(
    val source: Vertex<T>,
    val destination: Vertex<T>,
    val weight: Double? = null
)
