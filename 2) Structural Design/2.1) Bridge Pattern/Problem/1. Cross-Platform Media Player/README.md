### Problem Statement: **Cross-Platform Media Player**

**Requirement:**

You are tasked with designing a media player system that can play various types of media files (e.g., audio, video) on multiple platforms (e.g., Windows, macOS, Linux, Android).

The system should meet the following criteria:

1. **Abstraction Layer**:

   - Users should interact with the media player in a way that is independent of the platform they are on.
   - The media player should support basic operations like play, pause, and stop.

2. **Implementation Layer**:

   - The system should be extensible to support multiple media formats (e.g., MP4, MP3, MKV).
   - Each platform should have its own specific implementation of how to handle media playback.

3. **Extensibility**:
   - Adding support for a new platform or a new media type should require minimal changes to the existing codebase.

**Deliverables**:  
Design and implement this system using the Bridge Design Pattern. Make sure to include:

1. UML class diagram explaining the relationships between abstractions and implementations.
2. Code implementation in the programming language of your choice.
3. A brief explanation of how your design adheres to the Bridge Pattern and the advantages it provides in this context.
