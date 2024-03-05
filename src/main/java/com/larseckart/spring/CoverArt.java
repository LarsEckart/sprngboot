package com.larseckart.spring;

import java.io.Serializable;

public record CoverArt(String frontCoverArtUrl, String backCoverArtUrl, String upcCode) implements Serializable {
}
