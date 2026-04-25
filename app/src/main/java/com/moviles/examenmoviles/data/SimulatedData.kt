package com.moviles.examenmoviles.data

object SimulatedData {
    fun getSpaces(): List<Space> {
        return listOf(
            Space(
                id = "1",
                name = "Espacio Ejecutivo",
                description = "Oficina privada ideal para reuniones con pizarra y proyector",
                location = "Piso 3, Torre A",
                capacity = 6,
                pricePerHour = 15.0,
                isAvailable = true
            ),
            Space(
                id = "2",
                name = "Zona Colaborativa",
                description = "Area abierta con mesas compartidas ideal para freelancers",
                location = "Piso 1, Torre B",
                capacity = 20,
                pricePerHour = 8.0,
                isAvailable = true
            ),
            Space(
                id = "3",
                name = "Sala de Juntas Premium",
                description = "Sala con equipo audiovisual y videoconferencias",
                location = "Piso 5, Torre A",
                capacity = 12,
                pricePerHour = 25.0,
                isAvailable = false
            ),
            Space(
                id = "4",
                name = "Cubiculo Individual",
                description = "Espacio cerrado para una persona con escritorio y silla ergonomica",
                location = "Piso 2, Torre B",
                capacity = 1,
                pricePerHour = 10.0,
                isAvailable = true
            ),
            Space(
                id = "5",
                name = "Auditorio",
                description = "Gran salon para eventos o capacitaciones con equipo de sonido",
                location = "Piso 1, Torre A",
                capacity = 50,
                pricePerHour = 40.0,
                isAvailable = false
            )
        )
    }
}