/*
 * Copyright (C) 2022 Food and Agriculture Organization of the
 * United Nations (FAO-UN), United Nations World Food Programme (WFP)
 * and United Nations Environment Programme (UNEP)
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or (at
 * your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301, USA
 *
 * Contact: Jeroen Ticheler - FAO - Viale delle Terme di Caracalla 2,
 * Rome - Italy. email: geonetwork@osgeo.org
 */
package org.fao.geonet.kernel.security.openidconnect.bearer;


import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;

import java.util.Map;

/**
 * This decodes a JWT and validates its signature.  See JwtDecoderFactory.
 * The JwtDecoder also validates other parts of the JWT.
 */
public class SignatureValidatingTokenParser implements AccessTokenParser {

    JwtDecoder jwtDecoder;

    public SignatureValidatingTokenParser(JwtDecoder jwtDecoder) {
        jwtDecoder = jwtDecoder;
    }

    @Override
    public Map parseToken(String token) throws Exception {
        Jwt jwt = this.jwtDecoder.decode(token);
        return jwt.getClaims();
    }
}
