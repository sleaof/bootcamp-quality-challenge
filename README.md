# bootcamp-quality-challenge

Desafio Testing
O objetivo deste desafio é aplicar os conteúdos dados até o momento durante o Programa de aceleração MeLi (Git, Java e Spring), com ênfase principal nas validações e tipos de teste que podem ser usados a partir de uma proposta.

Status dos requisitos:
US 0001 - OK
US 0002 - OK
US 0003 - OK
US 0004 - OK

Endpoint: POST | http://localhost:8080/house
Body:
{
    "prop_name": "Exemplo",
    "prop_district": "Jd mathias",
    "rooms": [
        {
            "room_name": "Sala",
            "room_width": 25.0,
            "room_length": 33.0
        },
        {
            "room_name": "Cozinha",
            "room_width": 20.0,
            "room_length": 20.0
        },
        {
            "room_name": "Quarto um",
            "room_width": 25.0,
            "room_length": 30.0
        }
    ]
}

Bairro: os bairros estão no JSON district.json
