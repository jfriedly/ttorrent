Ttorrent, a Java implementation of the BitTorrent protocol
==========================================================

Description
-----------

**Ttorrent** is a pure-Java implementation of the BitTorrent protocol,
providing a BitTorrent tracker, a BitTorrent client and the related Torrent
metainfo files creation and parsing capabilities. It is designed to be embedded
into larger applications, but its components can also be used as standalone
programs.

Ttorrent supports the following BEPs (BitTorrent enhancement proposals):

* `BEP#0003`: The BitTorrent protocol specification  
  This is the base official protocol specification, which Ttorrent implements
  fully.
* `BEP#0012`: Multi-tracker metadata extension  
  Full support for the `announce-list` meta-info key providing a tiered tracker
  list.
* `BEP#0015`: UDP Tracker Protocol for BitTorrent  
  The UDP tracker protocol is fully supported in the BitTorrent client to make
  announce requests to UDP trackers. UDP tracker support itself is planned.
* `BEP#0020`: Peer ID conventions  
  Ttorrent uses `TO` as the client identification string, and currently uses
  the `-T00042-` client ID prefix.
* `BEP#0023`: Tracker Returns Compact Peer Lists  
  Compact peer lists are supported in both the client and the tracker.
  Currently the tracker only supports sending back compact peer lists
  to an announce request.

History
-------

This tool suite was implemented as part of Turn's (http://www.turn.com) release
distribution and deployment system and is used to distribute new build tarballs
to a large number of machines inside a datacenter as efficiently as possible.
At the time this project was started, few Java implementations of the
BitTorrent protocol existed and unfortunately none of them fit our needs:

* Vuze's, which is very hard to extract from their codebase, and thus complex
to re-integrate into another application;
* torrent4j, which is largely incomplete and not usable;
* Snark's, which is old, and unfortunately unstable;
* bitext, which was also unfortunately unstable, and extremely slow.

This implementation aims at providing a down-to-earth, simple to use library.
No fancy protocol extensions are implemented here: just the basics that allows
for the exchange and distribution of files through the BitTorrent protocol.

Although the write performance of the BitTorrent client is currently quite poor
(~10MB/sec/connected peer), it has been measured that the distribution of a
150MB file to thousands of machines across several datacenters took no more
than 30 seconds, with very little network overhead for the initial seeder (only
125% of the original file size uploaded by the initial seeder).

License
-------

This BitTorrent library is distributed under the terms of the Apache Software
License version 2.0. See COPYING file for more details.


Authors and contributors
------------------------

* Maxime Petazzoni <<mpetazzoni@turn.com>> (Platform Engineer at Turn, Inc)  
  Original author, main developer and maintainer
* David Giffin <<david@etsy.com>>  
  Contributed parallel hashing and multi-file torrent support.
* Thomas Zink <<thomas.zink@uni-konstanz.de>>  
  Fixed a piece length computation issue when the total torrent size is an
  exact multiple of the piece size.
* Johan Parent <<parent_johan@yahoo.com>>  
  Fixed a bug in unfresh peer collection and issues on download completion on
  Windows platforms.
* Dmitriy Dumanskiy  
  Contributed the switch from Ant to Maven.
* Alexey Ptashniy  
  Fixed an integer overflow in the calculation of a torrent's full size.


Caveats
-------

* Client write performance is a bit poor, mainly due to a (too?) simple piece
  caching algorithm.
* End-game can be slow if the peer selected to retrieve the last piece from
  doesn't upload fast enough (or at all). An end-game scenario should be
  implemented.

Contributions are welcome in all areas, even more so for these few points
above!