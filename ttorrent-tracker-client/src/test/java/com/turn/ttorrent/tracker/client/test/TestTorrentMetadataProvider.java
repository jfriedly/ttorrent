/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.turn.ttorrent.tracker.client.test;

import com.turn.ttorrent.tracker.client.TorrentMetadataProvider;
import com.turn.ttorrent.protocol.TorrentUtils;
import java.net.URI;
import java.util.List;
import javax.annotation.Nonnull;

/**
 *
 * @author shevek
 */
public class TestTorrentMetadataProvider implements TorrentMetadataProvider {

    private final byte[] infoHash;
    private final List<List<URI>> uris;

    public TestTorrentMetadataProvider(@Nonnull byte[] infoHash, @Nonnull List<List<URI>> uris) {
        this.infoHash = infoHash;
        this.uris = uris;
    }

    @Override
    public byte[] getInfoHash() {
        return infoHash;
    }

    @Override
    public State getState() {
        return State.SHARING;
    }

    @Override
    public List<? extends List<? extends URI>> getAnnounceList() {
        return uris;
    }

    @Override
    public long getUploaded() {
        return 0L;
    }

    @Override
    public long getDownloaded() {
        return 0L;
    }

    @Override
    public long getLeft() {
        return 0L;
    }

    @Override
    public String toString() {
        return "TestTorrentMetadataProvider(" + TorrentUtils.toHex(getInfoHash()) + ")";
    }
}
