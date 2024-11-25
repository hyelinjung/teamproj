package Service;

import Model.Vaccine;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VaccineService {

    public List<Vaccine> getAllVaccines() {
        // 예제 데이터
        List<Vaccine> vaccines = new ArrayList<>();
        vaccines.add(new Vaccine("결핵(BCG, 피내용)"));
        vaccines.add(new Vaccine("B형간염(HepB)"));
        vaccines.add(new Vaccine("디프테리아/파상풍/백일해(DTaP)"));
        vaccines.add(new Vaccine("파상풍/디프테리아(Td)"));
        vaccines.add(new Vaccine("파상풍/디프테리아/백일해(Tdap)"));
        vaccines.add(new Vaccine("폴리오(IPV)"));
        vaccines.add(new Vaccine("홍역/유행성이하선염/풍진(MMR)"));
        vaccines.add(new Vaccine("일본뇌염(불활성화 백신, 사백신)"));
        vaccines.add(new Vaccine("일본뇌염(약독화 생백신, 생백신)"));
        vaccines.add(new Vaccine("인플루엔자(Flu)"));
        vaccines.add(new Vaccine("B형헤모필루스인플루엔자(Hib)"));
        vaccines.add(new Vaccine("디프테리아/파상풍/백일해/폴리오(DTaP-IPV)"));
        vaccines.add(new Vaccine("디프테리아/파상풍/백일해/폴리오/Hib(DTaP-IPV/Hib)"));
        vaccines.add(new Vaccine("수두(VAR)"));
        vaccines.add(new Vaccine("A형간염(HepA)"));
        vaccines.add(new Vaccine("폐렴구균(PCV 13가)"));
        vaccines.add(new Vaccine("폐렴구균(PCV 10가)"));
        vaccines.add(new Vaccine("사람유두바이러스(HPV, 가다실) - 자궁경부암"));
        vaccines.add(new Vaccine("로타바이러스(로타릭스)"));
        vaccines.add(new Vaccine("로타바이러스(로타)"));
        return vaccines;
    }
}

