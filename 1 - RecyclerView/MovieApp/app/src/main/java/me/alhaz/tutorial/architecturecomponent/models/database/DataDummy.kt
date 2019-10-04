package me.alhaz.tutorial.architecturecomponent.models.database

import me.alhaz.tutorial.architecturecomponent.models.repositories.movie.remote.response.Movie

object DataDummy {

    fun generateListMovie(): ArrayList<Movie> {

        val movies = ArrayList<Movie>()

        // 1
        movies.add(
            Movie(
                id = 920,
                title = "Cars",
                voteAverage = 6.7,
                overview = "Lightning McQueen, a hotshot rookie race car driven to succeed, discovers that life is about the journey, not the finish line, when he finds himself unexpectedly detoured in the sleepy Route 66 town of Radiator Springs. On route across the country to the big Piston Cup Championship in California to compete against two seasoned pros, McQueen gets to know the town's offbeat characters.",
                overview_id = "Lightning McQueen, mobil balap rookie jagoan yang digerakkan untuk sukses, menemukan bahwa hidup adalah tentang perjalanan, bukan garis finish, ketika dia mendapati dirinya tiba-tiba berbelok di Radiator Springs, kota Route 66 yang mengantuk. Dalam perjalanan melintasi negara ke Kejuaraan Piala Piston besar di California untuk bersaing dengan dua pemain pro berpengalaman, McQueen mengenal karakter offbeat kota.",
                releaseDate = "2006-06-08",
                runtime = 117,
                posterPath = "/jpfkzbIXgKZqCZAkEkFH2VYF63s.jpg"
            )
        )

        // 2
        movies.add(
            Movie(
                id = 287947,
                title = "Shazam!",
                voteAverage = 7.1,
                overview = "A boy is given the ability to become an adult superhero in times of need with a single magic word.",
                overview_id = "Seorang anak laki-laki diberikan kemampuan untuk menjadi pahlawan dewasa di saat dibutuhkan dengan satu kata ajaib.",
                releaseDate = "2019-03-23",
                runtime = 132,
                posterPath = "/xnopI5Xtky18MPhK40cZAGAOVeV.jpg"
            )
        )

        // 3
        movies.add(
            Movie(
                id = 299534,
                title = "Avenger: Endgame",
                voteAverage = 8.4,
                overview = "After the devastating events of Avengers: Infinity War, the universe is in ruins due to the efforts of the Mad Titan, Thanos. With the help of remaining allies, the Avengers must assemble once more in order to undo Thanos' actions and restore order to the universe once and for all, no matter what consequences may be in store.",
                overview_id = "Setelah peristiwa yang menghancurkan dari Avengers: Perang Infinity, alam semesta hancur karena upaya Titan Gila, Thanos. Dengan bantuan sekutu yang tersisa, Avengers harus berkumpul sekali lagi untuk membatalkan tindakan Thanos dan mengembalikan ketertiban ke alam semesta sekali dan untuk semua, tidak peduli konsekuensi apa yang mungkin ada di toko.",
                releaseDate = "2019-02-24",
                runtime = 181,
                posterPath = "/or06FN3Dka5tukK1e9sl16pB3iy.jpg"
            )
        )

        // 4
        movies.add(
            Movie(
                id = 299536,
                title = "Avengers: Infinity War",
                voteAverage = 8.3,
                overview = "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                overview_id = "Ketika Avengers dan sekutu mereka terus melindungi dunia dari ancaman yang terlalu besar untuk ditangani oleh satu pahlawan, bahaya baru telah muncul dari bayang-bayang kosmik: Thanos. Seorang lalim penghinaan intergalaksi, tujuannya adalah untuk mengumpulkan semua enam Batu Infinity, artefak kekuatan tak terbayangkan, dan menggunakannya untuk menimbulkan keinginannya yang terpelintir pada semua kenyataan. Segala yang Avengers telah perjuangkan telah mengarah ke saat ini - nasib Bumi dan keberadaannya sendiri tidak pernah lebih pasti.",
                releaseDate = "2018-04-25",
                runtime = 149,
                posterPath = "/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg"
            )
        )

        // 5
        movies.add(
            Movie(
                id = 299537,
                title = "Captain Marvel",
                voteAverage = 7.8,
                overview = "Peter Parker and his friends go on a summer trip to Europe. However, they will hardly be able to rest - Peter will have to agree to help Nick Fury uncover the mystery of creatures that cause natural disasters and destruction throughout the continent.",
                overview_id = "Peter Parker dan teman-temannya melakukan perjalanan musim panas ke Eropa. Namun, mereka hampir tidak dapat beristirahat - Peter harus setuju untuk membantu Nick Fury mengungkap misteri makhluk yang menyebabkan bencana alam dan kehancuran di seluruh benua.",
                releaseDate = "2019-06-28",
                runtime = 124,
                posterPath = "/rjbNpRMoVvqHmhmksbokcyCr7wn.jpg"
            )
        )

        // 6
        movies.add(
            Movie(
                id = 301528,
                title = "Toy Story 4",
                voteAverage = 7.7,
                overview = "Woody has always been confident about his place in the world and that his priority is taking care of his kid, whether that's Andy or Bonnie. But when Bonnie adds a reluctant new toy called \"Forky\" to her room, a road trip adventure alongside old and new friends will show Woody how big the world can be for a toy.",
                overview_id = "Woody selalu yakin tentang tempatnya di dunia dan bahwa prioritasnya adalah merawat anaknya, apakah itu Andy atau Bonnie. Tetapi ketika Bonnie menambahkan mainan baru yang enggan disebut \"Forky\" ke kamarnya, petualangan perjalanan bersama teman-teman lama dan baru akan menunjukkan kepada Woody seberapa besar dunia untuk sebuah mainan.",
                releaseDate = "2019-06-19",
                runtime = 100,
                posterPath = "/w9kR8qbmQ01HwnvK4alvnQ2ca0L.jpg"
            )
        )

        // 7
        movies.add(
            Movie(
                id = 399579,
                title = "Alita: Battle Angel",
                voteAverage = 6.8,
                overview = "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                overview_id = "Ketika Alita terbangun tanpa ingatan tentang siapa dia di dunia masa depan yang tidak dia kenal, dia ditangkap oleh Ido, seorang dokter yang penuh kasih yang menyadari bahwa di suatu tempat dalam cangkang cyborg yang ditinggalkan ini adalah hati dan jiwa seorang wanita muda dengan luar biasa. lalu.",
                releaseDate = "2019-01-31",
                runtime = 119,
                posterPath = "/xRWht48C2V8XNfzvPehyClOvDni.jpg"
            )
        )

        // 8
        movies.add(
            Movie(
                id = 420818,
                title = "The Lion King",
                voteAverage = 7.1,
                overview = "Simba idolises his father, King Mufasa, and takes to heart his own royal destiny. But not everyone in the kingdom celebrates the new cub's arrival. Scar, Mufasa's brother—and former heir to the throne—has plans of his own. The battle for Pride Rock is ravaged with betrayal, tragedy and drama, ultimately resulting in Simba's exile. With help from a curious pair of newfound friends, Simba will have to figure out how to grow up and take back what is rightfully his.",
                overview_id = "Simba idolis ayahnya, Raja Mufasa, dan mengambil hati takdir kerajaannya sendiri. Tetapi tidak semua orang di kerajaan itu merayakan kedatangan anaknya yang baru. Scar, saudara lelaki Mufasa — dan mantan pewaris takhta — memiliki rencana sendiri. Pertempuran untuk Pride Rock dirusak dengan pengkhianatan, tragedi dan drama, yang akhirnya mengakibatkan pengasingan Simba. Dengan bantuan dari sepasang teman baru yang penasaran, Simba harus mencari cara untuk tumbuh dan mengambil kembali apa yang menjadi haknya.",
                releaseDate = "2019-07-12",
                runtime = 118,
                posterPath = "/dzBtMocZuJbjLOXvrl4zGYigDzh.jpg"
            )
        )

        // 9
        movies.add(
            Movie(
                id = 429617,
                title = "Spider-Man: Far from Home",
                voteAverage = 7.8,
                overview = "Peter Parker and his friends go on a summer trip to Europe. However, they will hardly be able to rest - Peter will have to agree to help Nick Fury uncover the mystery of creatures that cause natural disasters and destruction throughout the continent.",
                overview_id = "Peter Parker dan teman-temannya melakukan perjalanan musim panas ke Eropa. Namun, mereka hampir tidak dapat beristirahat - Peter harus setuju untuk membantu Nick Fury mengungkap misteri makhluk yang menyebabkan bencana alam dan kehancuran di seluruh benua.",
                releaseDate = "2019-06-28",
                runtime = 129,
                posterPath = "/rjbNpRMoVvqHmhmksbokcyCr7wn.jpg"
            )
        )

        // 10
        movies.add(
            Movie(
                id = 447404,
                title = "Pokémon Detective Pikachu",
                voteAverage = 7.0,
                overview = "In a world where people collect pocket-size monsters (Pokémon) to do battle, a boy comes across an intelligent monster who seeks to be a detective.",
                overview_id = "Di dunia di mana orang mengumpulkan monster ukuran saku (Pokémon) untuk melakukan pertempuran, seorang bocah lelaki menemukan monster cerdas yang berusaha menjadi detektif.",
                releaseDate = "2019-05-03",
                runtime = 105,
                posterPath = "/wgQ7APnFpf1TuviKHXeEe3KnsTV.jpg"
            )
        )

        // 11
        movies.add(
            Movie(
                id = 456740,
                title = "Hellboy",
                voteAverage = 5.0,
                overview = "Hellboy comes to England, where he must defeat Nimue, Merlin's consort and the Blood Queen. But their battle will bring about the end of the world, a fate he desperately tries to turn away.",
                overview_id = "Hellboy datang ke Inggris, di mana ia harus mengalahkan Nimue, permaisuri Merlin dan Ratu Darah. Tetapi pertempuran mereka akan membawa akhir dunia, nasib yang dengan putus asa dia coba untuk berpaling.",
                releaseDate = "2019-04-10",
                runtime = 121,
                posterPath = "/bk8LyaMqUtaQ9hUShuvFznQYQKR.jpg"
            )
        )

        // 12
        movies.add(
            Movie(
                id = 458156,
                title = "John Wick: Chapter 3 – Parabellum",
                voteAverage = 7.1,
                overview = "Super-assassin John Wick returns with a $14 million price tag on his head and an army of bounty-hunting killers on his trail. After killing a member of the shadowy international assassin’s guild, the High Table, John Wick is excommunicado, but the world’s most ruthless hit men and women await his every turn.",
                overview_id = "Super-pembunuh John Wick kembali dengan label harga \$ 14 juta di kepalanya dan sepasukan pembunuh pemburu hadiah di jejaknya. Setelah membunuh anggota guild pembunuh bayang-bayang internasional, High Table, John Wick dikucilkan, tetapi pria dan wanita hit paling kejam di dunia menunggu setiap gilirannya.",
                releaseDate = "2019-05-15",
                runtime = 131,
                posterPath = "/ziEuG1essDuWuC5lpWUaw1uXY2O.jpg"
            )
        )

        // 13
        movies.add(
            Movie(
                id = 459992,
                title = "Long Shot",
                voteAverage = 6.9,
                overview = "When Fred Flarsky reunites with and charms his first crush, Charlotte Field—one of the most influential women in the world. As Charlotte prepares to make a run for the Presidency, she hires Fred as her speechwriter and sparks fly.",
                overview_id = "Ketika Fred Flarsky bersatu kembali dengan dan memikat naksir pertamanya, Charlotte Field — salah satu wanita paling berpengaruh di dunia. Ketika Charlotte bersiap untuk mencalonkan diri sebagai Presiden, dia mempekerjakan Fred ketika penulis pidatonya dan bunga api beterbangan.",
                releaseDate = "2019-05-02",
                runtime = 125,
                posterPath = "/m2ttWZ8rMRwIMT7zA48Jo6mTkDS.jpg"
            )
        )

        // 14
        movies.add(
            Movie(
                id = 466272,
                title = "Once Upon a Time in Hollywood",
                voteAverage = 8.0,
                overview = "A faded television actor and his stunt double strive to achieve fame and success in the film industry during the final years of Hollywood's Golden Age in 1969 Los Angeles.",
                overview_id = "Seorang aktor televisi yang pudar dan aksi gandanya berusaha untuk mencapai ketenaran dan kesuksesan di industri film selama tahun-tahun terakhir Hollywood Golden Age pada 1969 di Los Angeles.",
                releaseDate = "2019-07-25",
                runtime = 161,
                posterPath = "/8j58iEBw9pOXFD2L0nt0ZXeHviB.jpg"
            )
        )

        // 15
        movies.add(
            Movie(
                id = 479455,
                title = "Men in Black: International",
                voteAverage = 5.9,
                overview = "The Men in Black have always protected the Earth from the scum of the universe. In this new adventure, they tackle their biggest, most global threat to date: a mole in the Men in Black organization.The Men in Black have always protected the Earth from the scum of the universe. In this new adventure, they tackle their biggest, most global threat to date: a mole in the Men in Black organization.",
                overview_id = "The Men in Black selalu melindungi Bumi dari buangan alam semesta. Dalam petualangan baru ini, mereka menangani ancaman terbesar, paling global hingga saat ini: tikus dalam organisasi Men in Black.",
                releaseDate = "2019-06-12",
                runtime = 115,
                posterPath = "/dPrUPFcgLfNbmDL8V69vcrTyEfb.jpg"
            )
        )

        // 16
        movies.add(
            Movie(
                id = 486589,
                title = "Red Shoes and the Seven Dwarfs",
                voteAverage = 8.0,
                overview = "Princes who have been turned into Dwarfs seek the red shoes of a lady in order to break the spell, although it will not be easy.",
                overview_id = "Pangeran yang telah berubah menjadi Kurcaci mencari sepatu merah wanita untuk memecahkan mantera, meskipun itu tidak akan mudah.",
                releaseDate = "2019-07-25",
                runtime = 0,
                posterPath = "/xQccIXfq9J4tgbvdSSPPLLYZGRD.jpg"
            )
        )

        // 17
        movies.add(
            Movie(
                id = 511987,
                title = "Crawl",
                voteAverage = 5.9,
                overview = "While struggling to save her father during a Category 5 hurricane, a young woman finds herself trapped inside a flooding house and fighting for her life against Florida’s most savage and feared predators.",
                overview_id = "Ketika berjuang untuk menyelamatkan ayahnya selama badai Kategori 5, seorang wanita muda menemukan dirinya terjebak di dalam rumah banjir dan berjuang untuk hidupnya melawan predator paling kejam dan ditakuti di Florida.",
                releaseDate = "2019-07-11",
                runtime = 87,
                posterPath = "/mKxpYRIrCZLxZjNqpocJ2RdQW8v.jpg"
            )
        )

        // 18
        movies.add(
            Movie(
                id = 553100,
                title = "Wild and Free",
                voteAverage = 6.0,
                overview = "Ellie and Jake fall in love, but struggle with their relationship when they discover an unexpected connection between their pasts.",
                overview_id = "Ellie dan Jake jatuh cinta, tetapi berjuang dengan hubungan mereka ketika mereka menemukan hubungan tak terduga antara masa lalu mereka.",
                releaseDate = "2018-10-10",
                runtime = 106,
                posterPath = "/jLGNqaymD0ygyhafhv5fM3nXcge.jpg"
            )
        )

        // 19
        movies.add(
            Movie(
                id = 566555,
                title = "Detective Conan: The Fist of Blue Sapphire",
                voteAverage = 5.0,
                overview = "23rd movie in the \"Detective Conan\" franchise.",
                overview_id = "Film ke-23 dalam franchise \"Detective Conan\".",
                releaseDate = "2019-04-12",
                runtime = 95,
                posterPath = "/86Y6qM8zTn3PFVfCm9J98Ph7JEB.jpg"
            )
        )

        // 20
        movies.add(
            Movie(
                id = 613473,
                title = "Burglary",
                voteAverage = 3.0,
                overview = "While playing videogames Mike spots a mysterious masked man outside his building.",
                overview_id = "Saat bermain videogame, Mike melihat seorang pria bertopeng misterius di luar gedungnya.",
                releaseDate = "2019-07-19",
                runtime = 6,
                posterPath = "/xztkk3qwvjTfKArjTkhWUCuadFY.jpg"
            )
        )

        return movies
    }
}