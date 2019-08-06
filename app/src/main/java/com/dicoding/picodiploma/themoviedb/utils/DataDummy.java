package com.dicoding.picodiploma.themoviedb.utils;

import com.dicoding.picodiploma.themoviedb.data.source.local.entity.model.MovieEntity;
import com.dicoding.picodiploma.themoviedb.data.source.local.entity.model.TvShowEntity;

import java.util.ArrayList;

public class DataDummy {

    public static ArrayList<MovieEntity> generateDummyMovies() {
        ArrayList<MovieEntity> movies = new ArrayList<>();

        movies.add(new MovieEntity("a14",
                "Spider Man Far From Home",
                "Peter Parker and his friends go on a summer trip to Europe. However, they will hardly be able to rest - Peter will have to agree to help Nick Fury uncover the mystery of creatures that cause natural disasters and destruction throughout the continent.",
                "02-07-2019",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/q1ZcgXatgXo58tUO3vEsrJhYSbu.jpg"));

        movies.add(new MovieEntity("a15",
                "Toy Story 4",
                "Woody has always been confident about his place in the world and that his priority is taking care of his kid, whether that's Andy or Bonnie. But when Bonnie adds a reluctant new toy called \"Forky\" to her room, a road trip adventure alongside old and new friends will show Woody how big the world can be for a toy.",
                "19-06-2019",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/w9kR8qbmQ01HwnvK4alvnQ2ca0L.jpg"));

        movies.add(new MovieEntity("b13",
                "Alita:Battle Angle",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "14-02-2019",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/xRWht48C2V8XNfzvPehyClOvDni.jpg"));

        movies.add(new MovieEntity("C15",
                "JHON WICK:Chapter 3-Parrabellum",
                "Super-assassin John Wick returns with a $14 million price tag on his head and an army of bounty-hunting killers on his trail. After killing a member of the shadowy international assassin’s guild, the High Table, John Wick is excommunicado, but the world’s most ruthless hit men and women await his every turn.",
                "17-05-2019",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/ziEuG1essDuWuC5lpWUaw1uXY2O.jpg"));

        movies.add(new MovieEntity("b14",
                "Lion King",
                "Simba idolises his father, King Mufasa, and takes to heart his own royal destiny. But not everyone in the kingdom celebrates the new cub's arrival. Scar, Mufasa's brother—and former heir to the throne—has plans of his own. The battle for Pride Rock is ravaged with betrayal, tragedy and drama, ultimately resulting in Simba's exile. With help from a curious pair of newfound friends, Simba will have to figure out how to grow up and take back what is rightfully his.",
                "19-07-2019",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/no2HvBMyXp9hf1L3yNNKwnk0XFE.jpg"));

        movies.add(new MovieEntity("b15",
                "Captain Marvel",
                "The story follows Carol Danvers as she becomes one of the universe's most powerful heroes when Earth is caught in the middle of a galactic war between two alien races. Set in the 1990s, Captain Marvel is an all-new adventure from a previously unseen period in the history of the Marvel Cinematic Universe.",
                "08-02-2019",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/zSOuQ1u8tjUCPhTC9Aujd2ICkdR.jpg"));

        movies.add(new MovieEntity("b16",
                "Aladdin",
                "A kindhearted street urchin named Aladdin embarks on a magical adventure after finding a lamp that releases a wisecracking genie while a power-hungry Grand Vizier vies for the same lamp that has the power to make their deepest wishes come true.",
                "24-05-2019",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/3iYQTLGoy7QnjcUYRJy4YrAgGvp.jpg"));

        movies.add(new MovieEntity("b17",
                "HellBoy",
                "HellBoy comes to England, where he must defeat Nimue, Merlin's consort and the Blood Queen. But their battle will bring about the end of the world, a fate he desperately tries to turn away.",
                "12-04-2019",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/bk8LyaMqUtaQ9hUShuvFznQYQKR.jpg"));

        movies.add(new MovieEntity("b18",
                "Avengers:Endgame",
                "After the devastating events of Avengers: Infinity War, the universe is in ruins due to the efforts of the Mad Titan, Thanos. With the help of remaining allies, the Avengers must assemble once more in order to undo Thanos' actions and restore order to the universe once and for all, no matter what consequences may be in store.",
                "26-04-2019",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/or06FN3Dka5tukK1e9sl16pB3iy.jpg"));

        movies.add(new MovieEntity("b19",
                "Avengers:Infinity War",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "27-04-2018",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg"));


        return movies;
    }

    public static ArrayList<TvShowEntity> generateDummyTvShows() {
        ArrayList<TvShowEntity> tvShows = new ArrayList<>();

        tvShows.add(new TvShowEntity("d15",
                "See No Evil: The Moors Murders",
                "The dramatisation of one of the most notorious killing sprees in British history.",
                "14-05-2019",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/b71BaRjp9TwxUZodLGgSRIlkfL8.jpg"));

        tvShows.add(new TvShowEntity("d16",
                "One-Punch Man",
                "Saitama is a hero who only became a hero for fun. After three years of “special” training, though, he's become so strong that he's practically invincible. In fact, he's too strong—even his mightiest opponents are taken out with a single punch, and it turns out that being devastatingly powerful is actually kind of a bore. With his passion for being a hero lost along with his hair, yet still faced with new enemies every day, how much longer can he keep it going?",
                "04-10-2-19",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/iE3s0lG5QVdEHOEZnoAxjmMtvne.jpg"));

        tvShows.add(new TvShowEntity("d19",
                "Stranger Things",
                "When a young boy vanishes, a small town uncovers a mystery involving secret experiments, terrifying supernatural forces, and one strange little girl.",
                "15-07-2019",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/x2LSRK2Cm7MZhjluni1msVJ3wDF.jpg"));

        tvShows.add(new TvShowEntity("d17",
                "Arrow",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "10-10-2012",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/mo0FP1GxOFZT4UDde7RFDz5APXF.jpg"));

        tvShows.add(new TvShowEntity("d18",
                "Game of Thrones",
                "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                "14-04-2019",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg"));

        tvShows.add(new TvShowEntity("d19",
                "Supergirl",
                "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
                "26-09-2015",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/vqBsgL9nd2v04ZvCqPzwtckDdFD.jpg"));

        tvShows.add(new TvShowEntity("e14",
                "Prison Break",
                "Due to a political conspiracy, an innocent man is sent to death row and his only hope is his brother, who makes it his mission to deliberately get himself sent to the same prison in order to break the both of them out, from the inside out.",
                "29-07-2005",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/oMFtDk8hgX9UM4dVEOJt8mcFmHC.jpg"));

        tvShows.add(new TvShowEntity("e15",
                "The 100",
                "100 years in the future, when the Earth has been abandoned due to radioactivity, the last surviving humans live on an ark orbiting the planet — but the ark won't last forever. So the repressive regime picks 100 expendable juvenile delinquents to send down to Earth to see if the planet is still habitable.",
                "19-04-2014",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/wBzNjurA8ijJPF21Ggs9nbviIzi.jpg"));

        tvShows.add(new TvShowEntity("e16",
                "Suits",
                "While running from a drug deal gone bad, Mike Ross, a brilliant young college-dropout, slips into a job interview with one of New York City's best legal closers, Harvey Specter. Tired of cookie-cutter law school grads, Harvey takes a gamble by hiring Mike on the spot after he recognizes his raw talent and photographic memory.",
                "23-06-2011",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/dE5s2yagw4CNOSznMwn0LMBmPbx.jpg"));

        tvShows.add(new TvShowEntity("e17",
                "Isekai Cheat Magician",
                "As regular high school students Taichi and Rin disappeared in a beam of light. When they came to, the two of them were already in a world of swords and magic. Finally getting away after experiencing an attack by monsters, following the suggestion of adventurers they headed on the path towards the guild. In the guild, the two of them found out that they possessed unbelievably powerful magic. Thus the regular high school students transformed into the strongest cheats.",
                "10-07-2019",
                "https://image.tmdb.org/t/p/w600_and_h900_bestv2/vtAJAku94Fm3OVsHx9w04XhsTk3.jpg"));

        return tvShows;
    }

}