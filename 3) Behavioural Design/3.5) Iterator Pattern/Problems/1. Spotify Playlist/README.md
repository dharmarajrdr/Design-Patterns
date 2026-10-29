# Problem Statement: Spotify Playlist

You are building a music streaming application like Spotify. One of the features you want to implement is a playlist that allows users to add songs and iterate through them. 
The playlist should support adding songs, removing songs, and iterating through the songs in the order they were added.

## Requirements:
1. Create a `Song` class that has attributes for the song's title and artist.
2. Create a `Playlist` class that allows users to add songs, remove songs, and iterate through the songs in the order they were added.
3. User can iterate through the playlist using different iterators like following:
    - `ForwardIterator`: Iterates through the songs from the first to the last.
    - `ReverseIterator`: Iterates through the songs from the last to the first.
    - `ShuffleIterator`: Iterates through the songs in a random order.
    - `ArtistIterator`: Iterates through the songs by a specific artist.
    - `FavoriteIterator`: Iterates through the songs that are marked as favorites.
4. The system should be scalable and a new iterator can be added without modifying the existing code.
