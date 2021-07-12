import org.junit.Test;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * 正则表达式用例
 *
 *@author zfd
 *@date 2021/5/25 11:14
 *@version v1.0
 */
public class Demo {

    @Test
    public void test1() {
        //查找以Java开头,任意结尾的字符串
        Pattern p = Pattern.compile("^Java.*");
        Matcher matcher = p.matcher("Java不是人吗");
        System.out.println(matcher.matches());
    }

    @Test
    public void test2() {
        // 以多条件分割字符串时
        Pattern p = Pattern.compile("[,|]+");
        String[] strs = p.split("Java Hello World Java,Hello,,World|Sun");
        for (String str : strs) {
            System.out.println(str);
        }
    }

    @Test
    public void test3() {
        Pattern pattern = Pattern.compile("正则表达式");
        Matcher matcher = pattern.matcher("正则表达式 Hello World,正则表达式 Hello World");
        //替换第一个符合正则的数据
        System.out.println(matcher.replaceFirst("Java"));
        // 全部替换
        System.out.println(matcher.replaceAll("Java"));
        // 文字替换（置换字符）
        matcher = pattern.matcher("正则表达式 Hello World,正则表达式 Hello World");
        StringBuffer sbr = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sbr, "Java");
        }
        matcher.appendTail(sbr);
        System.out.println(sbr.toString());
    }

    /**
     * 验证是否为邮箱地址
     */
    @Test
    public void test4() {
        String str = "ceponline@yahoo.com.cn";
        String regex = "[\\w\\.\\-]+@[\\w]+\\.[\\w\\.\\-]+";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        System.out.println(matcher.matches());
    }

    /**
     * ◆查找html中对应条件字符串
     */
    @Test
    public void test5() {
        Pattern pattern = Pattern.compile("href=\"(.+?)\"");
        Matcher matcher = pattern.matcher("<a href=\"index.html\">主页</a>");
        if (matcher.find())
            System.out.println(matcher.group(1));

    }

    /**
     * 去除html标记
     */
    @Test
    public void test6() {
        Pattern pattern = Pattern.compile("<.+?>", Pattern.DOTALL);
        Matcher matcher = pattern.matcher("<a href=\"index.html\">主页</a>123");
        String string = matcher.replaceAll("");
        System.out.println(string);
    }

    /**
     * 截取http://地址
     */
    @Test
    public void test7() {
        Pattern pattern = Pattern.compile("(https://|http://){1}[\\w\\.\\-\\:/]+");
        String str = "dsdsds<http://dsds//gfgffdfd>fdf";
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            System.out.println(matcher.group(0));
        }

    }


    public static void main(String[] args) {
        String str = "36RGKGCMVM16D4B\n" +
                "36RGKGCMVM16D4B\n" +
                "36RGKGCMVM16D4B\n" +
                "36RGKGCMVM16D4B\n" +
                "36PA7H9PN9C5449\n" +
                "0531W7CC0D80F48\n" +
                "02CDCN0ACC1C04B\n" +
                "02CDCN0ACC1C04B\n" +
                "44QPJ18HGJEAC4A\n" +
                "44QPJ18HGJEAC4A\n" +
                "02T5SJZFX631448\n" +
                "02T5SJZFX631448\n" +
                "44QPJ18HGJEAC4A\n" +
                "44QPJ18HGJEAC4A\n" +
                "44QPJ18HGJEAC4A\n" +
                "02T5SJZFX631448\n" +
                "02T5SJZFX631448\n" +
                "02T5SJZFX631448\n" +
                "02T5SJZFX631448\n" +
                "02T5SJZFX631448\n" +
                "166GS3YTBR1D349\n" +
                "166GS3YTBR1D349\n" +
                "166GS3YTBR1D349\n" +
                "02YMRBMZVFA2B48\n" +
                "02YMRBMZVFA2B48\n" +
                "02YMRBMZVFA2B48\n" +
                "02YMRBMZVFA2B48\n" +
                "02YMRBMZVFA2B48\n" +
                "02YMRBMZVFA2B48\n" +
                "02YMRBMZVFA2B48\n" +
                "44MG6JT3H1DCD4A\n" +
                "05NLZSTBMNCC14B\n" +
                "05EKSFR2T845F49\n" +
                "05EKSFR2T845F49\n" +
                "05EKSFR2T845F49\n" +
                "05EKSFR2T845F49\n" +
                "05EKSFR2T845F49\n" +
                "05EKSFR2T845F49\n" +
                "449MYLYLUZA5748\n" +
                "449MYLYLUZA5748\n" +
                "23HTWWRTTZC2749\n" +
                "166GS3YTBR1D349\n" +
                "14JQXH99J264849\n" +
                "14JQXH99J264849\n" +
                "166GS3YTBR1D349\n" +
                "14JQXH99J264849\n" +
                "44W9DZBCMZ5154B\n" +
                "44W9DZBCMZ5154B\n" +
                "44W9DZBCMZ5154B\n" +
                "23HTWWRTTZC2749\n" +
                "05J92PZMEG1BE4A\n" +
                "02KRGAAKHV20548\n" +
                "44W9DZBCMZ5154B\n" +
                "16Q5YNNCX96B94A\n" +
                "16Q5YNNCX96B94A\n" +
                "16Q5YNNCX96B94A\n" +
                "05J92PZMEG1BE4A\n" +
                "36EH51ZH13E0A4A\n" +
                "36EH51ZH13E0A4A\n" +
                "05AR4BT6S933D49\n" +
                "36EH51ZH13E0A4A\n" +
                "36EH51ZH13E0A4A\n" +
                "05AR4BT6S933D49\n" +
                "36EH51ZH13E0A4A\n" +
                "05AR4BT6S933D49\n" +
                "05K0K3E5JMF004A\n" +
                "36S3WFM7UZ5D14A\n" +
                "05PQ1WVXEMDC34B\n" +
                "35FVXUEK83E5248\n" +
                "05K0K3E5JMF004A\n" +
                "35FVXUEK83E5248\n" +
                "05PQ1WVXEMDC34B\n" +
                "00SRBGYBU0CFB49\n" +
                "36MWCT4TAX95B48\n" +
                "36MWCT4TAX95B48\n" +
                "05TPA2SD0Q24F48\n" +
                "16FCWUYVPZDA84B\n" +
                "167CRGHKNH8F24A\n" +
                "167CRGHKNH8F24A\n" +
                "20U3UNR4192E249\n" +
                "20LZ9ZKJRXEB54A\n" +
                "20LZ9ZKJRXEB54A\n" +
                "057KHGU95MB6F49\n" +
                "366598YB6981E4A\n" +
                "02EN1Y9KDRE414A\n" +
                "366598YB6981E4A\n" +
                "424WCMCKVZ1814B\n" +
                "20LZ9ZKJRXEB54A\n" +
                "05EKSFR2T845F49\n" +
                "05EKSFR2T845F49\n" +
                "02T6S3AVL54E54A\n" +
                "0291NRHVS3BA44A\n" +
                "0090DDDM45A8348\n" +
                "366598YB6981E4A\n" +
                "366598YB6981E4A\n" +
                "05EKSFR2T845F49\n" +
                "366598YB6981E4A\n" +
                "366598YB6981E4A\n" +
                "17M6R42RAP13F48\n" +
                "0296CNXFU68D04A\n" +
                "20K46RE6M96DB4B\n" +
                "166GS3YTBR1D349\n" +
                "00FLXBZDK57CB49\n" +
                "00FLXBZDK57CB49\n" +
                "00FLXBZDK57CB49\n" +
                "05EKSFR2T845F49\n" +
                "05EKSFR2T845F49\n" +
                "00FLXBZDK57CB49\n" +
                "02W7ZRBPYXDC649\n" +
                "00FLXBZDK57CB49\n" +
                "00FLXBZDK57CB49\n" +
                "05EKSFR2T845F49\n" +
                "05EKSFR2T845F49\n" +
                "169RDHWEFX45D48\n" +
                "169RDHWEFX45D48\n" +
                "169RDHWEFX45D48\n" +
                "17077E202MC654B\n" +
                "169RDHWEFX45D48\n" +
                "14JQXH99J264849\n" +
                "163JXTJQQLBFE4B\n" +
                "00C0FYW071F7448\n" +
                "02V5QN7G1G40148\n" +
                "05Y64AN3GUA5A4A\n" +
                "05BPSC9KBL29349\n" +
                "05BPSC9KBL29349\n" +
                "05H3WNJ8QU4C74A\n" +
                "02MDZABTXV29F4B\n" +
                "02QQQPWZ8X82B4B\n" +
                "21V95HQN9199C4A\n" +
                "20W14UD2TH62948\n" +
                "05082FNTF6B534B\n" +
                "16TCBSSNXH1DB4A\n" +
                "05BPSC9KBL29349\n" +
                "3660XB82PF05C49\n" +
                "0210E9A4S9EBA4B\n" +
                "0210E9A4S9EBA4B\n" +
                "36MYLEJRBS67448\n" +
                "36MYLEJRBS67448\n" +
                "021HQD94AUE924B\n" +
                "207MW7PZHC5D448\n" +
                "207MW7PZHC5D448\n" +
                "02Q66CSQMYC7E48\n" +
                "207MW7PZHC5D448\n" +
                "207MW7PZHC5D448\n" +
                "1681VN2XPEB0D4B\n" +
                "38WF1BZHB04EA4A\n" +
                "025HUXFT2C2104A\n" +
                "21CP68UKRV5AA48\n" +
                "21CP68UKRV5AA48\n" +
                "02G5BPXKFD1AF48\n" +
                "20NM0ZY5SRB264A\n" +
                "14TW1QT9Y34C448\n" +
                "02FM1XPZY0B5B48\n" +
                "36MYLEJRBS67448\n" +
                "05082FNTF6B534B\n" +
                "05VYP2MGL4E844A\n" +
                "05VYP2MGL4E844A\n" +
                "008NYDXWQNE9948\n" +
                "35H192SU229324A\n" +
                "35H192SU229324A\n" +
                "053EGLB6HS1434B\n" +
                "21CP68UKRV5AA48\n" +
                "056TZ56R5W64549\n" +
                "056TZ56R5W64549\n" +
                "056TZ56R5W64549\n" +
                "02ZY5TVBE113948\n" +
                "053HNAAG3CBD64B\n" +
                "053HNAAG3CBD64B\n" +
                "36P1DWYS07E9248\n" +
                "14TW1QT9Y34C448\n" +
                "0210E9A4S9EBA4B\n" +
                "02S6XGG98GE2D48\n" +
                "02S6XGG98GE2D48\n" +
                "44KKF8KHNG5134A\n" +
                "0210E9A4S9EBA4B\n" +
                "17QM4WVBZB9AC4A\n" +
                "17QM4WVBZB9AC4A\n" +
                "17QM4WVBZB9AC4A\n" +
                "02F8CGX68U6AC4B\n" +
                "022N0AG1PE09749\n" +
                "17QM4WVBZB9AC4A\n" +
                "05GZTSB89M35D4A\n" +
                "16DH3SFTH7E3249\n" +
                "17QM4WVBZB9AC4A\n" +
                "370HJV6BP5BB748\n" +
                "16DH3SFTH7E3249\n" +
                "370HJV6BP5BB748\n" +
                "05ZN8EA7YC3F24A\n" +
                "02GUPRVYWS52948\n" +
                "02CR0EPFPV3394B\n" +
                "02Z52BVVB4DC84B\n" +
                "35H192SU229324A\n" +
                "02MEAHPCN35004B\n" +
                "216GDHPVTQ7CB49\n" +
                "05EKSFR2T845F49\n" +
                "17M6R42RAP13F48\n" +
                "17M6R42RAP13F48\n" +
                "17M6R42RAP13F48\n" +
                "14R0DQ32F5B8948\n" +
                "16ES88XS0G94C48\n" +
                "02T349EF0Y3AF4A\n" +
                "02XQ9USP9N0E649\n" +
                "020ZCRBPNBB1F4A\n" +
                "02MT0S0DNZ4C24A\n" +
                "02MT0S0DNZ4C24A\n" +
                "02MT0S0DNZ4C24A\n" +
                "02T349EF0Y3AF4A\n" +
                "05BXF4VYA6B654A\n" +
                "05BXF4VYA6B654A\n" +
                "05BXF4VYA6B654A\n" +
                "020684QXFPABF4B\n" +
                "020684QXFPABF4B\n" +
                "020684QXFPABF4B\n" +
                "44QPJ18HGJEAC4A\n" +
                "007Z8CMV9A4A84B\n" +
                "02NQLNNU8VED149\n" +
                "02ZXPJ3EC7CFB49\n" +
                "02ZXPJ3EC7CFB49\n" +
                "02NQLNNU8VED149\n" +
                "02NQLNNU8VED149\n" +
                "02ZXPJ3EC7CFB49\n" +
                "02U26BJSKAB874A\n" +
                "028A9JEH247D948\n" +
                "02UAVSBJ0N5B449\n" +
                "16DH3SFTH7E3249\n" +
                "02QRJTM3514EC49\n" +
                "02QRJTM3514EC49\n" +
                "003A1PCVET31D4B\n" +
                "05QH18XA8Q84D4B\n" +
                "05QH18XA8Q84D4B\n" +
                "05BSZZGGGW1934B\n" +
                "05ZN8EA7YC3F24A\n" +
                "05ZN8EA7YC3F24A\n" +
                "35H192SU229324A\n" +
                "02L3LNDH827B24A\n" +
                "16SDNDXVKE50B49\n" +
                "02RHPDER9YF754A\n" +
                "02RHPDER9YF754A\n" +
                "02RHPDER9YF754A\n" +
                "17RJZJXEYG6FA4B\n" +
                "29WFYVW6SJ2FE4B\n" +
                "00C0FYW071F7448\n" +
                "17963Y2NYQ74A4B\n" +
                "00C0FYW071F7448\n" +
                "17963Y2NYQ74A4B\n" +
                "00C0FYW071F7448\n" +
                "00P8AS4NTJF2C48\n" +
                "02J7UK3HSV7224A\n" +
                "02J7UK3HSV7224A\n" +
                "02J7UK3HSV7224A\n" +
                "35Y9TAWEZU1FC49\n" +
                "35Y9TAWEZU1FC49\n" +
                "35Y9TAWEZU1FC49\n" +
                "029YUW7LPM21748\n" +
                "35H192SU229324A\n" +
                "02GV3KRK4QAA64A\n" +
                "05RSPWPWH7F8E4A\n" +
                "02V5QN7G1G40148\n" +
                "20NM0ZY5SRB264A\n" +
                "20NM0ZY5SRB264A\n" +
                "175HU8G2LCAE049\n" +
                "175HU8G2LCAE049\n" +
                "0272NBJ0N0EB749\n" +
                "0272NBJ0N0EB749\n" +
                "02NQLNNU8VED149\n" +
                "36FFRN4EKS6FA49\n" +
                "35713DH446DD848\n" +
                "35713DH446DD848\n" +
                "02K004NZ46D6849\n" +
                "0288EZF0TQCF449\n" +
                "0288EZF0TQCF449\n" +
                "023AXPRNXUFBD48\n" +
                "38CXHP4JGS6C349\n" +
                "05M49NPGPB7684A\n" +
                "0004RHQKCTBC04A\n" +
                "05M49NPGPB7684A\n" +
                "16YB4RA071B5449\n" +
                "05VTTA6B22EED49\n" +
                "05BSZZGGGW1934B\n" +
                "35VHK3ER4R41F4B\n" +
                "023G5TNVG47E249\n" +
                "05BG0VBZEM7BA4B\n" +
                "219X3KVVWEA8A49\n" +
                "05BXF4VYA6B654A\n" +
                "00C0FYW071F7448\n" +
                "00C0FYW071F7448\n" +
                "17RJZJXEYG6FA4B\n" +
                "02WHR2FR3N6DB49\n" +
                "02WHR2FR3N6DB49\n" +
                "02WHR2FR3N6DB49\n" +
                "05ZZUCCNL539948\n" +
                "059RLCTNWV6EA4B\n" +
                "00P8AS4NTJF2C48\n" +
                "02J7UK3HSV7224A\n" +
                "05JWRDX3V68564B\n" +
                "05JWRDX3V68564B\n" +
                "05BXF4VYA6B654A\n" +
                "02T6S3AVL54E54A\n" +
                "05BXF4VYA6B654A\n" +
                "05BXF4VYA6B654A\n" +
                "05BXF4VYA6B654A\n" +
                "4496FXJUTQ85F49\n" +
                "00Y9DJGQN3E8049\n" +
                "16YB4RA071B5449\n" +
                "02V5QN7G1G40148\n" +
                "02V5QN7G1G40148\n" +
                "02V5QN7G1G40148\n" +
                "02V5QN7G1G40148\n" +
                "02V5QN7G1G40148\n" +
                "16FKLEUT7F03949\n" +
                "05VTTA6B22EED49\n" +
                "05VTTA6B22EED49\n" +
                "022V786KQMF274B\n" +
                "05KS75N1HC0914B\n" +
                "05KS75N1HC0914B\n" +
                "056TZ56R5W64549\n" +
                "056TZ56R5W64549\n" +
                "205VYVZGQU7FA48\n" +
                "00118A5FN95B34A\n" +
                "02NQLNNU8VED149\n" +
                "02NQLNNU8VED149\n" +
                "05A7BTULGE69A49\n" +
                "05BG0VBZEM7BA4B\n" +
                "05BG0VBZEM7BA4B\n" +
                "02BJTG6WUK33F4A\n" +
                "02WHR2FR3N6DB49\n" +
                "02WHR2FR3N6DB49\n" +
                "059RLCTNWV6EA4B\n" +
                "059RLCTNWV6EA4B\n" +
                "05MYDQ4UDD32C4B\n" +
                "00JNCA8D5K99A48\n" +
                "00JNCA8D5K99A48\n" +
                "00JNCA8D5K99A48\n" +
                "026XAR1VEZ63248\n" +
                "05BXF4VYA6B654A\n" +
                "00LLUEHGQVBA149\n" +
                "3718SLUUCSFF84B\n" +
                "02T6S3AVL54E54A\n" +
                "056PVVMYNTDFD48\n" +
                "44V2LQDSHJF004A\n" +
                "36KXN2WU3BA824A\n" +
                "44V2LQDSHJF004A\n" +
                "16PA3TH38G4FD4B\n" +
                "02MYX0MA1MA404B\n" +
                "05NXWBZHVAF5748\n" +
                "02PWUKYBHR3104A\n" +
                "00S090SLBXD4D4A\n" +
                "02Y4GGWVGP94D49\n" +
                "3693E9F1FX9844A\n" +
                "056TZ56R5W64549\n" +
                "054L6N8P3PDB94B\n" +
                "05GGU0VU33F3449\n" +
                "056TZ56R5W64549\n" +
                "056TZ56R5W64549\n" +
                "05A7BTULGE69A49\n" +
                "02WJADGEEGF144B\n" +
                "16NDKGN36S7AD4A\n" +
                "05LD3Y012C01E4B\n" +
                "164D89S7A565549\n" +
                "164D89S7A565549\n" +
                "05XU28T3W076E49\n" +
                "00R3RHNAY8E554A\n" +
                "44PKJSR2Z71664A\n" +
                "00NKFMV1K13BE48\n" +
                "3812VB72RCF0248\n" +
                "3812VB72RCF0248\n" +
                "16WCZPD42V70349\n" +
                "3812VB72RCF0248\n" +
                "05S8J4RM8F8EB4B\n" +
                "17NU0Q7SSMAE94B\n" +
                "05S8J4RM8F8EB4B\n" +
                "023P8KX78NEE749\n" +
                "02Y78SPP3C93D48\n" +
                "0236EDPK6PE4249\n" +
                "16BXZ8LBLJ1A249\n" +
                "16BXZ8LBLJ1A249\n" +
                "00H9B79A0054848\n" +
                "00H9B79A0054848\n" +
                "02HE8H4TVX66748\n" +
                "00H9B79A0054848\n" +
                "05418YKEF195B48\n" +
                "056TZ56R5W64549\n" +
                "05GGU0VU33F3449\n" +
                "05LKDF8B9C3354A\n" +
                "02B7A735TQ19A48\n" +
                "02B7A735TQ19A48\n" +
                "05BP4YMQAEE974B\n" +
                "02B7A735TQ19A48\n" +
                "02WJADGEEGF144B\n" +
                "022V8KY7PCF984B\n" +
                "02FQFRMN3NAA349\n" +
                "44TX078DM354B49\n" +
                "44TX078DM354B49\n" +
                "05PGHHU13L51549\n" +
                "05PGHHU13L51549\n" +
                "02RXAF6JHEC2549\n" +
                "02RXAF6JHEC2549\n" +
                "05LD3Y012C01E4B\n" +
                "164D89S7A565549\n" +
                "203F7HRS3598249\n" +
                "203F7HRS3598249\n" +
                "050KH61JJG72A49\n" +
                "05S8J4RM8F8EB4B\n" +
                "44TX078DM354B49\n" +
                "05S8J4RM8F8EB4B\n" +
                "05A6R7QET93A249\n" +
                "02AH217L8D9284A\n" +
                "0236EDPK6PE4249\n" +
                "16PPG9GX0T0254B\n" +
                "216VGXW2VGC1049\n" +
                "02PFHXBUN5AA648\n" +
                "36TENXT2CXC974B\n" +
                "056A7XU1KDE314B\n" +
                "00H9B79A0054848\n" +
                "00H9B79A0054848\n" +
                "00UJDXW0V95514B\n" +
                "167ABXJJUS3F14A\n" +
                "02G2LCH3YPF724B\n" +
                "02HE8H4TVX66748\n" +
                "020E5LQ00UA054B\n" +
                "020E5LQ00UA054B\n" +
                "00UFMZG9Q696A4B\n" +
                "021AVER1G3F5148\n" +
                "021AVER1G3F5148\n" +
                "05N0M644PLB3B48\n" +
                "00ZKDH6S4F4DD48\n" +
                "056KP1G3J8F8849\n" +
                "056KP1G3J8F8849\n" +
                "056KP1G3J8F8849\n" +
                "44TX078DM354B49\n" +
                "05JU8FP3YX6804B\n" +
                "05A6R7QET93A249\n" +
                "059A9B3S5YC1F48\n" +
                "059A9B3S5YC1F48\n" +
                "0296DT6SC81C34A\n" +
                "0296DT6SC81C34A\n" +
                "20S11228DE7E649\n" +
                "440BP4B6F956D48\n" +
                "440BP4B6F956D48\n" +
                "02FC0VHE2Y10049\n" +
                "02FC0VHE2Y10049\n" +
                "020VQNLBTC1964A\n" +
                "025S37DNK92E349\n" +
                "00TN325ZWX4D748\n" +
                "02J6J776KR60E49\n" +
                "058VQCGFS1D5749\n" +
                "020E5LQ00UA054B\n" +
                "05RD6U5XRQF734A\n" +
                "02YJQU1GTUEB348\n" +
                "05QHUVZ1JW7D448\n" +
                "05MFF79SKQ78A4A\n" +
                "21SWEG9GM40CB4B\n" +
                "21SWEG9GM40CB4B\n" +
                "21SWEG9GM40CB4B\n" +
                "051XMF6LVD7CE4A\n" +
                "0252QW5PZ8E644A\n" +
                "05LKQ172W0F7B48\n" +
                "051XMF6LVD7CE4A\n" +
                "051XMF6LVD7CE4A\n" +
                "0252QW5PZ8E644A\n" +
                "0252QW5PZ8E644A\n" +
                "051XMF6LVD7CE4A\n" +
                "05Y7CGTHKAF774B\n" +
                "02MEAHPCN35004B\n" +
                "29YD5DBYUB92D4A\n" +
                "05NJQFV3F89A34B\n" +
                "02SZJPR2QR7334A\n" +
                "02TE2L7FBT71149\n" +
                "02R87PDC7KBB44A\n" +
                "05AHUUL6U71D44A\n" +
                "02D5ALT4P04004A\n" +
                "169C08U1VF08149\n" +
                "05J6M3VN7BE7C48\n" +
                "02D5ALT4P04004A\n" +
                "05AHUUL6U71D44A\n" +
                "02MEAHPCN35004B\n" +
                "02R87PDC7KBB44A\n" +
                "0241Q3GBY3DE64B\n" +
                "0210E9A4S9EBA4B\n" +
                "054BY1AL9V00F49\n" +
                "02DKQCMCPS3D848\n" +
                "052WTDDWX889548\n" +
                "02MEAHPCN35004B\n" +
                "0241Q3GBY3DE64B\n" +
                "020E5LQ00UA054B\n" +
                "02U80NH3B9A494B\n" +
                "02YR20VT2213C4A\n" +
                "02R87PDC7KBB44A\n" +
                "02MEAHPCN35004B\n" +
                "02RB0DLB9804848\n" +
                "02U80NH3B9A494B\n" +
                "02U80NH3B9A494B\n" +
                "052WTDDWX889548\n" +
                "02DKQCMCPS3D848\n" +
                "35Q1WFUGY071B48\n" +
                "02R87PDC7KBB44A\n" +
                "02RQF62GU2F7F49\n" +
                "020E5LQ00UA054B\n" +
                "056TZ56R5W64549\n" +
                "02U80NH3B9A494B";
//        System.out.println(str);
        String[] split = str.split("\n");
        String collect = Arrays.stream(split).map(item -> "'" + item + "'").collect(Collectors.joining(",", "(", ")"));
        System.out.println(collect);
    }

}

