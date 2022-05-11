package com.example.laboratoriono5_6.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.example.laboratoriono5_6.R
import com.example.laboratoriono5_6.databinding.ActivityLoginBinding
import com.example.laboratoriono5_6.databinding.ActivityMenuBinding
import com.example.laboratoriono5_6.model.artista
import com.example.laboratoriono5_6.model.evento
import com.example.laboratoriono5_6.model.pintura
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.firestore.FirebaseFirestore
import org.json.JSONArray
import org.json.JSONObject

class activityMenu : AppCompatActivity() {
    private lateinit var binding:ActivityMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val menuartelista:BottomNavigationView = findViewById(R.id.bottomNavMenu)
        setupWithNavController(menuartelista, findNavController(this, R.id.frag_navgraph))

        val jsonEvento = JSONArray("[\n" +
                "            {\n" +
                "                'Hora1': '9:00 AM',\n" +
                "                'EventoLugar': 'Universidad Nacional de Ingeniería (UNI)',\n" +
                "                'EventoDireccion' : 'Managua, Nicaragua',\n" +
                "                'EventoLatitud': '12.132217502029128',\n" +
                "                'EventoLongitud': '-86.26987020617783',\n" +
                "                'EventoTelefono': '22700973',\n" +
                "                'EventoWebSite': 'https://www.uni.edu.ni',\n" +
                "                'EventoPhoto': 'https://lh5.googleusercontent.com/p/AF1QipPBc_8YcZrVDAYJQVNxsFShaUBt1fMXaP524MSk=w408-h306-k-no'\n" +
                "            },\n" +
                "            {\n" +
                "                'Hora1': '10:00AM',\n" +
                "                'EventoLugar': 'Palacio Nacional Nicaragua',\n" +
                "                'EventoDireccion' : 'Managua, Nicaragua',\n" +
                "                'EventoLatitud': '12.155753468843768',\n" +
                "                'EventoLongitud': '-86.27181158240545',\n" +
                "                'EventoTelefono': '22700973',\n" +
                "                'EventoWebSite': 'https://www.uni.edu.ni',\n" +
                "                'EventoPhoto': 'https://lh5.googleusercontent.com/p/AF1QipPBc_8YcZrVDAYJQVNxsFShaUBt1fMXaP524MSk=w408-h306-k-no'\n" +
                "            },\n" +
                "            {\n" +
                "                'Hora1': '11:00AM',\n" +
                "                'EventoLugar': 'Catedral de León',\n" +
                "                'EventoDireccion' : 'León, Nicaragua',\n" +
                "                'EventoLatitud': '12.435324873993144',\n" +
                "                'EventoLongitud': '-86.87811227445178',\n" +
                "                'EventoTelefono': '22700973',\n" +
                "                'EventoWebSite': 'https://www.uni.edu.ni',\n" +
                "                'EventoPhoto': 'https://lh5.googleusercontent.com/p/AF1QipNs-Imj8nYgJGnGzSX3RBTyF0Wb8JUgrDEPzRAZ=w408-h306-k-no'\n" +
                "            },\n" +
                "            {\n" +
                "                'Hora1': '18:00PM',\n" +
                "                'EventoLugar': 'Centro Cultural Mercado de Artesanías',\n" +
                "                'EventoDireccion' : 'Masaya, Nicaragua',\n" +
                "                'EventoLatitud': '11.974114551016928',\n" +
                "                'EventoLongitud': '-86.09356818480153',\n" +
                "                'EventoTelefono': '22700973',\n" +
                "                'EventoWebSite': 'https://www.uni.edu.ni',\n" +
                "                'EventoPhoto': 'https://lh5.googleusercontent.com/p/AF1QipMKisJvZoWZRi2fwisVPJ4nedCTavDfhD_l1gOK=w426-h240-k-no'\n" +
                "            },\n" +
                "            {\n" +
                "                'Hora1': '20:00PM',\n" +
                "                'EventoLugar': 'HISPAMER',\n" +
                "                'EventoDireccion' : 'Managua, Nicaragua',\n" +
                "                'EventoLatitud': '12.126254938201553',\n" +
                "                'EventoLongitud': '-86.27016318794827',\n" +
                "                'EventoTelefono': '+505 22700973',\n" +
                "                'EventoWebSite': 'https://www.uni.edu.ni',\n" +
                "                'EventoPhoto': 'https://lh5.googleusercontent.com/p/AF1QipMKisJvZoWZRi2fwisVPJ4nedCTavDfhD_l1gOK=w426-h240-k-no'\n" +
                "            },\n" +
                "            {\n" +
                "                'Hora1': '08:00AM',\n" +
                "                'EventoLugar': 'Galerías Santo Domingo',\n" +
                "                'EventoDireccion' : 'Managua, Nicaragua',\n" +
                "                'EventoLatitud': '12.103822159374769',\n" +
                "                'EventoLongitud': '-86.24928744561913',\n" +
                "                'EventoTelefono': '+505 22700973',\n" +
                "                'EventoWebSite': 'http://www.galerias.com.ni',\n" +
                "                'EventoPhoto': 'https://lh5.googleusercontent.com/p/AF1QipMJLS9UryEMUMehmqyw9RdkE2x09fALdQcHZmGd=w520-h240-k-no'\n" +
                "            },\n" +
                "            {\n" +
                "                'Hora1': '09:30AM',\n" +
                "                'EventoLugar': 'Centro de Arte Fundación Ortiz Gurdián',\n" +
                "                'EventoDireccion' : 'León, Nicaragua',\n" +
                "                'EventoLatitud': '12.435021697165867',\n" +
                "                'EventoLongitud': '-86.8819260032871',\n" +
                "                'EventoTelefono': '+505 22700973',\n" +
                "                'EventoWebSite': 'http://www.fundacionortizgurdian.org',\n" +
                "                'EventoPhoto': 'https://lh5.googleusercontent.com/p/AF1QipNnjAmM3pSJF3lQBM_izBl2NW2FPnx7KeT9hehA=w426-h240-k-no'\n" +
                "            },\n" +
                "            {\n" +
                "                'Hora1': '10:00AM',\n" +
                "                'EventoLugar': 'Gabriel House',\n" +
                "                'EventoDireccion' : 'Leche Agria Muu, Managua',\n" +
                "                'EventoLatitud': '12.1205678',\n" +
                "                'EventoLongitud': '-86.2099729',\n" +
                "                'EventoTelefono': '+505 22700973',\n" +
                "                'EventoWebSite': 'http://www.uni.edu.ni',\n" +
                "                'EventoPhoto': 'https://elcomercio.pe/resizer/pfVziOV4X8Vu9nwknDc-oNItlB8=/1200x900/smart/filters:format(jpeg):quality(75)/cloudfront-us-east-1.images.arcpublishing.com/elcomercio/6Y2EDIISGFGVFANEVDCR5LCG34.jpg'\n" +
                "            }\n" +
                "        ]")

        val jsonArtista = JSONArray("[\n" +
                "            {\n" +
                "                'ArtistaNombre' : 'Robert Lewandoski',\n" +
                "                'ArtistaCategoria' : 'Bayern Munich',\n" +
                "                'ArtistaPais' : 'Alemania',\n" +
                "                'ArtistaPerfil' : 'Jugador del Bayer de Munich',\n" +
                "            },\n" +
                "            {\n" +
                "                'ArtistaNombre' : 'Cristiano Ronaldo',\n" +
                "                'ArtistaCategoria' : 'Manchester United',\n" +
                "                'ArtistaPais' : 'Portugal',\n" +
                "                'ArtistaPerfil' : 'Jugador del Manchester United',\n" +
                "            },\n" +
                "            {\n" +
                "                'ArtistaNombre': 'Peter Cech',\n" +
                "                'ArtistaCategoria': 'Manchester United',\n" +
                "                'ArtistaPais': 'Alemania',\n" +
                "                'ArtistaPerfil' : 'Jugador del Manchester United',\n" +
                "            },\n" +
                "            {\n" +
                "                'ArtistaNombre': 'Neymar Junior',\n" +
                "                'ArtistaCategoria': 'Paris Saint-Germain',\n" +
                "                'ArtistaPais': 'Brasil',\n" +
                "                'ArtistaPerfil' : 'Jugador del Paris Saint-Germain',\n" +
                "            },\n" +
                "            {\n" +
                "                'ArtistaNombre': 'Harry Kane',\n" +
                "                'ArtistaCategoria': 'Tottenham',\n" +
                "                'ArtistaPais': 'Inglaterra',\n" +
                "                'ArtistaPerfil' : 'Jugador del Tottenham',\n" +
                "            }\n" +
                "           {\n" +
                "                'ArtistaNombre': 'Eden Hazard',\n" +
                "                'ArtistaCategoria': 'Real Madrid',\n" +
                "                'ArtistaPais': 'Alemania',\n" +
                "                'ArtistaPerfil' : 'Jugador del Real Madrid',\n" +
                "            }\n" +
                "           {\n" +
                "                'ArtistaNombre': 'Vinicius Junior',\n" +
                "                'ArtistaCategoria': 'Real MAdrid',\n" +
                "                'ArtistaPais': 'Brasil',\n" +
                "                'ArtistaPerfil' : 'Jugador del Real Madrid',\n" +
                "            }\n" +
                "           {\n" +
                "                'ArtistaNombre': 'Lionel Messi',\n" +
                "                'ArtistaCategoria': 'Paris Saint-Germain',\n" +
                "                'ArtistaPais': 'Argentina',\n" +
                "                'ArtistaPerfil' : 'Jugador del Paris Saint-Germain',\n" +
                "            }\n" +
                "           {\n" +
                "                'ArtistaNombre': 'Kylian Mbappe',\n" +
                "                'ArtistaCategoria': 'Paris Saint-Germain',\n" +
                "                'ArtistaPais': 'Francia',\n" +
                "                'ArtistaPerfil' : 'Jugador del Paris Saint-Germain',\n" +
                "            }\n" +
                "           {\n" +
                "                'ArtistaNombre': 'Adama Toure',\n" +
                "                'ArtistaCategoria': 'FC Barcelona',\n" +
                "                'ArtistaPais': 'Inglaterra',\n" +
                "                'ArtistaPerfil' : 'Jugador del FC Barcelona',\n" +
                "            }\n" +
                "        ]")

        val jsonGaleria = JSONArray("[\n" +
                "            {\n" +
                "                'ArtistaPintura' : 'City 2 - 3 Madrid',\n" +
                "                'TituloPintura' : 'Partido de Vuelta',\n" +
                "                'PrecioPintura' : '1,600',\n" +
                "                'UrlPintura' : 'https://as01.epimg.net/futbol/imagenes/2022/04/26/champions/1650948733_580917_1651005910_noticia_normal_recorte1.jpg'\n" +
                "            },\n" +
                "            {\n" +
                "                'ArtistaPintura' : 'Liverpool 3 - 1 Benfica',\n" +
                "                'TituloPintura' : 'Partido de Vuelta',\n" +
                "                'PrecioPintura' : '1,243',\n" +
                "                'UrlPintura' : 'https://futbolenlinea.club/wp-content/uploads/2022/04/10-cosas-clave-que-debes-saber-antes-del-Benfica-vs.jpg'\n" +
                "            },\n" +
                "            {\n" +
                "                'ArtistaPintura' : 'Madrid 3 - 1 Chelsea',\n" +
                "                'TituloPintura' : 'Partido de Vuelta',\n" +
                "                'PrecioPintura' : '1,564',\n" +
                "                'UrlPintura' : 'https://phantom-marca.unidadeditorial.es/d7b8216569c07bbc3bef9f65b0c2f2d2/resize/1320/f/jpg/assets/multimedia/imagenes/2022/04/12/16497917794736.jpg'\n" +
                "            },\n" +
                "            {\n" +
                "                'ArtistaPintura' : 'Atletico 0 - 1 City',\n" +
                "                'TituloPintura' : 'Partido de Vuelta',\n" +
                "                'PrecioPintura' : '650',\n" +
                "                'UrlPintura' : 'https://depor.com/resizer/MCe7HI2WXY-suURrO3Z4cpVm-5g=/580x330/smart/filters:format(jpeg):quality(75)/cloudfront-us-east-1.images.arcpublishing.com/elcomercio/ZA22T2A5WFBEVIXBMIRTP4MRYE.jpg'\n" +
                "            }\n" +
                "        ]")

        val fireDB: FirebaseFirestore = FirebaseFirestore.getInstance()

        for (i in 0 until jsonEvento.length()) {
            val objevento = jsonEvento.get(i) as JSONObject
            var Evento = evento()
            Evento.Hora1 = objevento.getString("Hora1")
            Evento.EventoLugar = objevento.getString("EventoLugar")
            Evento.EventoDireccion = objevento.getString("EventoDireccion")
            Evento.EventoLatitud = objevento.getString("EventoLatitud").toDouble()
            Evento.EventoLongitud = objevento.getString("EventoLongitud").toDouble()
            Evento.EventoTelefono = objevento.getString("EventoTelefono")
            Evento.EventoWebSite = objevento.getString("EventoWebSite")
            Evento.EventoFoto = objevento.getString("EventoFoto")
            fireDB.collection("Evento").document().set(Evento)
        }

        for (i in 0 until jsonArtista.length())
        {
            val objArtista = jsonArtista.get(i) as JSONObject
            var Artista = artista()

            Artista.ArtistaNombre = objArtista.getString("ArtistaNombre")
            Artista.ArtistaCategoria = objArtista.getString("ArtistaCategoria")
            Artista.ArtistaPais = objArtista.getString("ArtistaPais")
            Artista.ArtistaPerfil = objArtista.getString("ArtistaPerfil")
            fireDB.collection("Artista").document().set(Artista)
        }

        for (i in 0 until jsonGaleria.length())
        {
            val objGaleria = jsonGaleria.get(i) as JSONObject
            var Galeria = pintura()

            Galeria.ArtistaPintura = objGaleria.getString("ArtistaPintura")
            Galeria.PrecioPintura = objGaleria.getString("PrecioPintura")
            Galeria.UrlPintura = objGaleria.getString("UrlPintura")
            Galeria.TituloPintura = objGaleria.getString("TituloPintura")
            fireDB.collection("Galeria").document().set(Galeria)
        }
        
    }
}