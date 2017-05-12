/*
*  Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
*  Unless required by applicable law or agreed to in writing,
*  software distributed under the License is distributed on an
*  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
*  KIND, either express or implied.  See the License for the
*  specific language governing permissions and limitations
*  under the License.
*/
package org.ballerinalang.util.parser.antlr4;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.ballerinalang.model.WhiteSpaceDescriptor;
import org.ballerinalang.util.parser.BallerinaParser;

import java.util.List;

/**
 * Provide helpers to extract whitespace for each construct from token stream.
 *
 * @see BLangAntlr4Listener
 * @since 0.9.0
 */
public class WhiteSpaceUtil {

    public static WhiteSpaceDescriptor getImportDeclarationWS(CommonTokenStream tokenStream,
                                                              BallerinaParser.ImportDeclarationContext ctx) {
        WhiteSpaceDescriptor ws = new WhiteSpaceDescriptor();
        ws.addWhitespaceRegion(WhiteSpaceRegions.IMPORT_DEC_IMPORT_KEYWORD_TO_PKG_NAME_START,
                                getWhitespaceToRight(tokenStream, ctx.start.getTokenIndex()));
        ws.addWhitespaceRegion(WhiteSpaceRegions.IMPORT_DEC_PKG_NAME_END_TO_SEMICOLAN,
                getWhitespaceToRight(tokenStream, ctx.packageName().stop.getTokenIndex()));
        ws.addWhitespaceRegion(WhiteSpaceRegions.IMPORT_DEC_END_TO_NEXT_TOKEN,
                getWhitespaceToRight(tokenStream, ctx.stop.getTokenIndex()));
        return ws;
    }

    public static String getWhitespaceToRight(CommonTokenStream tokenStream, int tokenIndex) {
        StringBuilder whitespaceBuilder = new StringBuilder();
        if (tokenStream != null) {
            List<Token> hiddenTokensToRight = tokenStream.getHiddenTokensToRight(tokenIndex, Token.HIDDEN_CHANNEL);
            if (hiddenTokensToRight != null) {
                for (Token next : hiddenTokensToRight) {
                    whitespaceBuilder.append(next.getText());
                }
            }
        }
        return whitespaceBuilder.toString();
    }

    public static String getWhitespaceToLeft(CommonTokenStream tokenStream, int tokenIndex) {
        StringBuilder whitespaceBuilder = new StringBuilder();
        if (tokenStream != null) {
            List<Token> hiddenTokensToRight = tokenStream.getHiddenTokensToLeft(tokenIndex, Token.HIDDEN_CHANNEL);
            if (hiddenTokensToRight != null) {
                for (Token next : hiddenTokensToRight) {
                    whitespaceBuilder.append(next.getText());
                }
            }
        }
        return whitespaceBuilder.toString();
    }

    public static WhiteSpaceDescriptor getPackageDeclarationWS(CommonTokenStream tokenStream, BallerinaParser.PackageDeclarationContext ctx) {
        WhiteSpaceDescriptor ws = new WhiteSpaceDescriptor();
        ws.addWhitespaceRegion(WhiteSpaceRegions.BFILE_PKG_KEYWORD_TO_PKG_NAME_START,
                getWhitespaceToRight(tokenStream, ctx.start.getTokenIndex()));
        ws.addWhitespaceRegion(WhiteSpaceRegions.BFILE_PKG_NAME_END_TO_SEMICOLON,
                getWhitespaceToRight(tokenStream, ctx.packageName().start.getTokenIndex()));
        ws.addWhitespaceRegion(WhiteSpaceRegions.BFILE_PKG_DEC_END_TO_NEXT_TOKEN,
                getWhitespaceToRight(tokenStream, ctx.stop.getTokenIndex()));
        return ws;
    }
}
