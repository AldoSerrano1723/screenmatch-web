package com.aluracursos.screenmatch.service;

import com.aluracursos.screenmatch.dto.EpisodioDTO;
import com.aluracursos.screenmatch.dto.SerieDTO;
import com.aluracursos.screenmatch.model.Categoria;
import com.aluracursos.screenmatch.model.Episodio;
import com.aluracursos.screenmatch.model.Serie;
import com.aluracursos.screenmatch.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SerieService {

    @Autowired
    private SerieRepository repository;

    public List<SerieDTO> obtenerTodasLasSeries() {
        return convierteDatos(repository.findAll());
    }

    public List<SerieDTO> obtenerTop5() {
        return convierteDatos(repository.findTop5ByOrderByEvaluacionDesc());
    }

    public List<SerieDTO> obtenerLanzamientosMasRecientes(){
        return convierteDatos(repository.lanzamientosMasRecientes());
    }

    private List<SerieDTO> convierteDatos (List<Serie> series){
        return series.stream()
                .map(serie -> new SerieDTO(
                        serie.getId(),
                        serie.getTitulo(),
                        serie.getTotalTemporadas(),
                        serie.getEvaluacion(),
                        serie.getPoster(),
                        serie.getGenero(),
                        serie.getActores(),
                        serie.getSinopsis()
                ))
                .collect(Collectors.toList());
    }

    public SerieDTO obtenerPorId(Long id){
         Optional<Serie> serie = repository.findById(id);
         if (serie.isPresent()){
             Serie s = serie.get();
             return new SerieDTO(s.getId(),
                     s.getTitulo(),
                     s.getTotalTemporadas(),
                     s.getEvaluacion(),
                     s.getPoster(),
                     s.getGenero(),
                     s.getActores(),
                     s.getSinopsis());
         } else {
             return null;
         }
    }

    public List<EpisodioDTO> obtenerTodasLasTemporadas(Long id) {
        Optional<Serie> serie = repository.findById(id);
        if (serie.isPresent()){
            Serie s = serie.get();
            return s.getEpisodios().stream()
                    .map(episodio -> new EpisodioDTO(
                            episodio.getTemporada(),
                            episodio.getTitulo(),
                            episodio.getNumeroEpisodio()
                    ))
                    .collect(Collectors.toList());
        } else {
            return null;
        }
    }

    public List<EpisodioDTO> obtenerTemporadasPorNumero(Long id, Integer numeroTemporada) {
        List<Episodio> listaDeEpisodios = repository.obtenerTemporadasPorNumero(id, numeroTemporada);
        return listaDeEpisodios.stream()
                .map(episodio -> new EpisodioDTO(
                        episodio.getTemporada(),
                        episodio.getTitulo(),
                        episodio.getNumeroEpisodio()
                ))
                .collect(Collectors.toList());

    }

    public List<SerieDTO> obtenerSeriesPorCategoria(String nombreGenero) {
        var categoria = Categoria.fromEspanol(nombreGenero);
        return convierteDatos(repository.findByGenero(categoria));
    }

    public List<EpisodioDTO> obtenerTop5Episodios(Long id) {

    }
}
