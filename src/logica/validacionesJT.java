/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Alumno
 */
public class validacionesJT {

    String letras = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZabcdefghijklmnñopqrstuvwxyz ";
    String numeros = "1234567890";
    String letMail = "@_-";
    String letSign = "-+";
    String letPoint = ".";
    String letSpecial = "{}[]¨*°!#$%&/()=?¡{},;:´'¿!#$%&/()°|¬~^`\\´¡¢£¤¥§¨©ª«¬®¯°±´µ¶·¸º»¿ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÑÒÓÔÕÖØÙÚÛÜßàáâãäåæçèéêëìíîïñòóôõö÷øùúûüÿ₫¦­²³¼½¾ÐðÞþ×‘OO'“OO”—O–O‚O„O;αΓβΛγΣπΠσΩς<>≠′≤″≥∂≡∫≈∑∞∏√•€™†ąĆćĈĉĊċČčĎďĐđĒēĔĕĖėĘęĚěĜĝ‡◊‰←↑→↓♠♣♥♦‹›☺☻♥♦♣♠•◘○◙♂♀♪♫☼►◄↕‼¶§▬↨↑↓→←∟↔▲▼¡“#$%&‘()*,–/:;<=>¿\\^`{|}~⌂ÇüéâäàåçêëèïîìÄÅÉæÆôöòûùÿÖÜø£Ø×ƒáíóúñÑªº¿®¬½¼¡«»░▒▓│┤ÁÂÀ©╣║╗╝¢¥┐└┴┬├─┼ãÃ╚╔╩╦╠═╬¤ðÐÊËÈıÍÎÏ┘┌█▄¦Ì▀ÓßÔÒõÕµþÞÚÛÛýÝ¯´­±‗¾¶§÷¸°¨•¹³²■ĀāĂăĄ�";
    
//286. Ğ
//287. ğ
//288. Ġ
//289. ġ
//290. Ģ
//291. ģ
//292. Ĥ
//293. ĥ
//294. Ħ
//295. ħ
//296. Ĩ
//297. ĩ
//298. Ī
//299. ī
//300. Ĭ
//301. ĭ
//302. Į
//303. į
//304. İ
//305. ı
//306. Ĳ
//307. ĳ
//308. Ĵ
//309. ĵ
//310. Ķ
//311. ķ
//312. ĸ
//313. Ĺ
//314. ĺ
//315. Ļ
//316. ļ
//317. Ľ
//318. ľ
//319. Ŀ
//320. ŀ
//321. Ł
//322. ł
//323. Ń
//324. ń
//325. Ņ
//326. ņ
//327. Ň
//328. ň
//329. ŉ
//330. Ŋ
//331. ŋ
//332. Ō
//333. ō
//334. Ŏ
//335. ŏ
//336. Ő
//337. ő
//338. Œ
//339. œ
//340. Ŕ
//341. ŕ
//342. Ŗ
//343. ŗ
//344. Ř
//345. ř
//346. Ś
//347. ś
//348. Ŝ
//349. ŝ
//350. Ş
//351. ş
//352. Š
//353. š
//354. Ţ
//355. ţ
//356. Ť
//357. ť
//358. Ŧ
//359. ŧ
//360. Ũ
//361. ũ
//362. Ū
//363. ū
//364. Ŭ
//365. ŭ
//366. Ů
//367. ů
//368. Ű
//369. ű
//370. Ų
//371. ų
//372. Ŵ
//373. ŵ
//374. Ŷ
//375. ŷ
//376. Ÿ
//377. Ź
//378. ź
//379. Ż
//380. ż
//381. Ž
//382. ž
//383. ſ
//384. ƀ
//385. Ɓ
//386. Ƃ
//387. ƃ
//388. Ƅ
//389. ƅ
//390. Ɔ
//391. Ƈ
//392. ƈ
//393. Ɖ
//394. Ɗ
//395. Ƌ
//396. ƌ
//397. ƍ
//398. Ǝ
//399. Ə
//400. Ɛ
//401. Ƒ
//402. ƒ
//403. Ɠ
//404. Ɣ
//405. ƕ
//406. Ɩ
//407. Ɨ
//408. Ƙ
//409. ƙ
//410. ƚ
//411. ƛ
//412. Ɯ
//413. Ɲ
//414. ƞ
//415. Ɵ
//416. Ơ
//417. ơ
//418. Ƣ
//419. ƣ
//420. Ƥ
//421. ƥ
//422. Ʀ
//423. Ƨ
//424. ƨ
//425. Ʃ
//426. ƪ
//427. ƫ
//428. Ƭ
//429. ƭ
//430. Ʈ
//431. Ư
//432. ư
//433. Ʊ
//434. Ʋ
//435. Ƴ
//436. ƴ
//437. Ƶ
//438. ƶ
//439. Ʒ
//440. Ƹ
//441. ƹ
//442. ƺ
//443. ƻ
//444. Ƽ
//445. ƽ
//446. ƾ
//447. ƿ
//448. ǀ
//449. ǁ
//450. ǂ
//451. ǃ
//452. Ǆ
//453. ǅ
//454. ǆ
//455. Ǉ
//456. ǈ
//457. ǉ
//458. Ǌ
//459. ǋ
//460. ǌ
//461. Ǎ
//462. ǎ
//463. Ǐ
//464. ǐ
//465. Ǒ
//466. ǒ
//467. Ǔ
//468. ǔ
//469. Ǖ
//470. ǖ
//471. Ǘ
//472. ǘ
//473. Ǚ
//474. ǚ
//475. Ǜ
//476. ǜ
//477. ǝ
//478. Ǟ
//479. ǟ
//480. Ǡ
//481. ǡ
//482. Ǣ
//483. ǣ
//484. Ǥ
//485. ǥ
//486. Ǧ
//487. ǧ
//488. Ǩ
//489. ǩ
//490. Ǫ
//491. ǫ
//492. Ǭ
//493. ǭ
//494. Ǯ
//495. ǯ
//496. ǰ
//497. Ǳ
//498. ǲ
//499. ǳ
//500. Ǵ
//501. ǵ
//502. Ƕ
//503. Ƿ
//504. Ǹ
//505. ǹ
//506. Ǻ
//507. ǻ
//508. Ǽ
//509. ǽ
//510. Ǿ
//511. ǿ
//512. Ȁ
//513. ȁ
//514. Ȃ
//515. ȃ
//516. Ȅ
//517. ȅ
//518. Ȇ
//519. ȇ
//520. Ȉ
//521. ȉ
//522. Ȋ
//523. ȋ
//524. Ȍ
//525. ȍ
//526. Ȏ
//527. ȏ
//528. Ȑ
//529. ȑ
//530. Ȓ
//531. ȓ
//532. Ȕ
//533. ȕ
//534. Ȗ
//535. ȗ
//536. Ș
//537. ș
//538. Ț
//539. ț
//540. Ȝ
//541. ȝ
//542. Ȟ
//543. ȟ
//544. Ƞ
//545. ȡ
//546. Ȣ
//547. ȣ
//548. Ȥ
//549. ȥ
//550. Ȧ
//551. ȧ
//552. Ȩ
//553. ȩ
//554. Ȫ
//555. ȫ
//556. Ȭ
//557. ȭ
//558. Ȯ
//559. ȯ
//560. Ȱ
//561. ȱ
//562. Ȳ
//563. ȳ
//564. ȴ
//565. ȵ
//566. ȶ
//567. ȷ
//568. ȸ
//569. ȹ
//570. Ⱥ
//571. Ȼ
//572. ȼ
//573. Ƚ
//574. Ⱦ
//575. ȿ
//576. ɀ
//577. Ɂ
//578. ɂ
//579. Ƀ
//580. Ʉ
//581. Ʌ
//582. Ɇ
//583. ɇ
//584. Ɉ
//585. ɉ
//586. Ɋ
//587. ɋ
//588. Ɍ
//589. ɍ
//590. Ɏ
//591. ɏ
//592. ɐ
//593. ɑ
//594. ɒ
//595. ɓ
//596. ɔ
//597. ɕ
//598. ɖ
//600. ɘ
//601. ə
//602. ɚ
//603. ɛ
//604. ɜ
//605. ɝ
//606. ɞ
//607. ɟ
//608. ɠ
//609. ɡ
//610. ɢ
//611. ɣ
//612. ɤ
//613. ɥ
//614. ɦ
//615. ɧ
//616. ɨ
//617. ɩ
//618. ɪ
//619. ɫ
//620. ɬ
//621. ɭ
//622. ɮ
//623. ɯ
//624. ɰ
//625. ɱ
//626. ɲ
//627. ɳ
//628. ɴ
//629. ɵ
//630. ɶ
//631. ɷ
//632. ɸ
//633. ɹ
//634. ɺ
//635. ɻ
//636. ɼ
//637. ɽ
//638. ɾ
//639. ɿ
//640. ʀ
//641. ʁ
//642. ʂ
//643. ʃ
//644. ʄ
//645. ʅ
//646. ʆ
//647. ʇ
//648. ʈ
//649. ʉ
//650. ʊ
//651. ʋ
//652. ʌ
//653. ʍ
//654. ʎ
//655. ʏ
//656. ʐ
//657. ʑ
//658. ʒ
//659. ʓ
//660. ʔ
//661. ʕ
//662. ʖ
//663. ʗ
//664. ʘ
//665. ʙ
//666. ʚ
//667. ʛ
//668. ʜ
//669. ʝ
//670. ʞ
//671. ʟ
//672. ʠ
//673. ʡ
//674. ʢ
//675. ʣ
//676. ʤ
//677. ʥ
//678. ʦ
//679. ʧ
//680. ʨ
//681. ʩ
//682. ʪ
//683. ʫ
//684. ʬ
//685. ʭ
//686. ʮ
//687. ʦ
//688. ʰ
//689. ʱ
//690. ʲ
//691. ʳ
//692. ʴ
//693. ʵ
//694. ʶ
//695. ʷ
//696. ʸ
//697. ʹ
//698. ʺ
//699. ʻ
//700. ʼ
//701. ʽ
//702. ʾ
//703. ʿ
//704. ˀ
//705. ˁ
//706. ˂
//707. ˃
//708. ˄
//709. ˅
//710. ˆ
//711. ˇ
//712. ˈ
//713. ˉ
//714. ˊ
//715. ˋ
//716. ˌ
//717. ˍ
//718. ˎ
//719. ˏ
//720. ː
//721. ˑ
//722. ˒
//723. ˓
//724. ˔
//725. ˕
//726. ˖
//727. ˗
//728. Ė
//729. ė
//730. ˚
//731. ˛
//732. ˜
//733. ˝
//734. ˞
//735. ˟
//736. ˠ
//737. ˡ
//738. ˢ
//739. ˣ
//740. ˤ
//741. ˥
//742. ˦
//743. ˧
//744. ˨
//745. ˩
//746. ˪
//747. ˫
//748. ˬ
//749. ˭
//750. ˮ
//751. ˯
//752. ˯
//753. ˱
//754. ˲
//755. ˳
//756. ˴
//757. ˵
//758. ˶
//759. ˷
//760. ˸
//761. ˹
//762. ˺
//763. ˻
//764. ˼
//765. ˽
//766. ˾
//767. ˿
//847. ͏
//848. ͐
//849. ͑
//850. ͒
//851. ͓
//852. ͔
//853. ͕
//854. ͖
//855. ͗
//856. ͘
//857. ͙
//858. ͚
//859. ͛
//860. ͛
//861.   ͜
//862. ͞
//863. ͟
//864. ͠
//865. ͡
//866. ͢
//867. ͣ
//868. ͤ
//869. ͥ
//870. ͥ
//871. ͧ
//872. ͨ
//873. ͩ
//874. ͪ
//875. ͫ
//876. ͬ
//877. ͭ
//878. ͮ
//879. ͯ
//880. Ͱ
//881. ͱ
//882. Ͳ
//883. ͳ
//884. ʹ
//885. ͵
//886. Ͷ
//887. ͷ
//888. ͸
//889. ͹
//890. ͺ
//891. ͻ
//892. ͼ
//893. ͽ
//894. ;
//895. Ϳ
//896. ΀
//897. ΁
//898. ΂
//899. ΃
//900. ΄
//901. ΅
//902. Ά
//903. ·
//904. Έ
//905. Ή
//906. Ί
//907. ΋
//908. Ό
//909. ΍
//910. Ύ
//911. Ώ
//912. ΐ
//913. Α
//914. Β
//915. Γ
//916. Δ
//917. Ε
//918. Ζ
//919. Η
//920. Θ
//921. Ι
//922. Κ
//923. Λ
//924. Μ
//925. Ν
//926. Ξ
//927. Ο
//928. Π
//929. Ρ
//930. ΢
//931. Σ
//932. Τ
//933. Υ
//934. Φ
//935. Χ
//936. Ψ
//937. Ω
//938. ΪΫάέήί̴̵̶̷̸̡̢̧̨̜̝̞̟̠̣̤̥̦̩̪̫̬̭̮̯̰̱̲̳̹̺̻̼͇͈͉͍͎̽̾̿̀́͂̓̈́͆͊͋͌ͅ͏͓͔͕͖͙͚͐͑͒͗͛͛ͣͤͥͥͧͨͩͪͫͬͭͮͯ͘͜͟͢͞͠͡ͰͱͲͳʹ͵Ͷͷ͸͹ͺͻͼͽ;Ϳ΀΁΂΃΄΅·΋Ό΍ΎΏΐΓΔΘΙΚΛΜΝΞΟΠΡ΢ΣΤΥΦΧΨΩΪΫάέήίΰαβγδεζɗ
    char letrA[] = letras.toCharArray();
    char numA[] = numeros.toCharArray();
    char mailA[] = letMail.toCharArray();
    char signo[] = letSign.toCharArray();
    char punto[] = letPoint.toCharArray();
    char special[] = letSpecial.toCharArray();

    boolean vacio = true, mai;
    int cLetras, cNumeros, cMail, cSigno, cPunto, cEspecial;

    public void evaluar(String k) {
        cLetras = 0;
        cNumeros = 0;
        cMail = 0;
        cSigno = 0;
        cPunto = 0;
        cEspecial=0;
        for (int i = 0 ; i < k.length(); i++) {//evaluador
            for (int j = 0; j < letras.length(); j++) {
                if (k.charAt(i) == letrA[j]) {//letras
                    cLetras++;
                } else if (j < numeros.length() && k.charAt(i) == numA[j]) {//numeros
                    cNumeros++;
                } else if (j < letMail.length() && k.charAt(i) == mailA[j]) {//numeros
                    cMail++;
                } else if (j < letSign.length() && k.charAt(i) == signo[j]) {//numeros y signo -
                    cSigno++;
                } else if (j == 0 && k.charAt(i) == punto[j]) {//numeros y signo -
                    cPunto++;
                } else if (j < letSpecial.length() && k.charAt(i) == special[j]) {//numeros y signo -
                    cEspecial++;
                } 
            }

        }
    }
    
    public boolean soloLetras(String s){
        evaluar(s);
//        int cLetras, cNumeros, cMail, cSigno, cPunto;
        System.out.println("Letras: "+cLetras);
        System.out.println("Numeros: "+cNumeros);
        System.out.println("Correo: "+cMail);
        System.out.println("Signo: "+cSigno);
        System.out.println("Puntos: "+cPunto);
        System.out.println("Especial: "+cEspecial);
        if(cLetras != 0 && cNumeros ==0 && cMail == 0 && cSigno ==0 && cPunto==0 && cEspecial==0){
            mai = true;
        }else{
            mai = false;
        }
        System.out.println("Solo letras: "+mai);
        return mai;
    }
    
    public boolean soloNumeros(String s){
        evaluar(s);
//        int cLetras, cNumeros, cMail, cSigno, cPunto;
        System.out.println("Letras: "+cLetras);
        System.out.println("Numeros: "+cNumeros);
        System.out.println("Correo: "+cMail);
        System.out.println("Signo: "+cSigno);
        System.out.println("Puntos: "+cPunto);
        System.out.println("Especial: "+cEspecial);
        if(cNumeros != 0 && cLetras==0  && cMail==0 && cSigno==0 && cPunto==0 && cEspecial==0){
            mai = true;
        }else{
            mai = false;
        }
        System.out.println("Solo numeros: "+mai);
        return mai;
    }
    
    public boolean sinEspecial(String s){
        evaluar(s);
//        int cLetras, cNumeros, cMail, cSigno, cPunto;
        System.out.println("Letras: "+cLetras);
        System.out.println("Numeros: "+cNumeros);
        System.out.println("Correo: "+cMail);
        System.out.println("Signo: "+cSigno);
        System.out.println("Puntos: "+cPunto);
        System.out.println("Especial: "+cEspecial);
        if((cLetras!=0 || cNumeros!=0) && cMail==0 && cSigno==0 && cPunto==0 && cEspecial==0){
            mai = true;
        }else{
            mai = false;
        }
        System.out.println("Sin especial: "+mai);
        return mai;
    }
    
    public boolean soloMail(String correo) {
        int arroba = 0,
                punto = 0,
                letra = 0,
                largo = correo.trim().length();
        
        evaluar(correo);
        System.out.println("Letras: "+cLetras);
        System.out.println("Numeros: "+cNumeros);
        System.out.println("Correo: "+cMail);
        System.out.println("Signo: "+cSigno);
        System.out.println("Puntos: "+cPunto);
        System.out.println("Especial: "+cEspecial);
        for (int i = 0; i < largo; i++) {

            switch (correo.charAt(i)) {
                case '@':
                    arroba++;
                    break;
                case '.':
                    punto++;
                    break;
                default:
                    letra++;
                    break;
            }
//            System.out.println(correo.charAt(i));
//            System.out.println(arroba);
//            System.out.println(punto);
//            System.out.println(letra + "\n");
        }
//        int cLetras, cNumeros, cMail, cSigno, cPunto;
        if (arroba == 1 && punto != 0 && (cLetras!=0 || cNumeros!=0) && cMail!=0 && cSigno==0 && cPunto!=0 && cEspecial==0) {
            mai = true;
        }else{
            mai = false;
        }
        System.out.println("Boolean Mail: " + mai);
        return mai;
    }

    public boolean evaluaCoord(String lat, String lg) {
        int arrobaA = 0,
                puntoA = 0,
                letraA = 0,
                arrobaO = 0,
                puntoO = 0,
                letraO = 0,
                largoA = lat.length(),
                largoO = lg.length();
        evaluar(lat);
        System.out.println("-------Latitud");
        System.out.println("Letras: "+cLetras);
        System.out.println("Numeros: "+cNumeros);
        System.out.println("Correo: "+cMail);
        System.out.println("Signo: "+cSigno);
        System.out.println("Puntos: "+cPunto);
        System.out.println("Especial: "+cEspecial);
        
        evaluar(lg);
        System.out.println("---------Longitud");
        System.out.println("Letras: "+cLetras);
        System.out.println("Numeros: "+cNumeros);
        System.out.println("Correo: "+cMail);
        System.out.println("Signo: "+cSigno);
        System.out.println("Puntos: "+cPunto);
        System.out.println("Especial: "+cEspecial);
        for (int i = 0; i < largoA; i++) {

            switch (lat.charAt(i)) {
                case '@':
                    arrobaA++;
                    break;
                case '.':
                    puntoA++;
                    break;
                default:
                    letraA++;
                    break;
            }
        }

        for (int i = 0; i < largoO; i++) {
            switch (lg.charAt(i)) {
                case '@':
                    arrobaO++;
                    break;
                case '.':
                    puntoO++;
                    break;
                default:
                    letraO++;
                    break;
            }
//            System.out.println(correo.charAt(i));
//            System.out.println(arroba);
//            System.out.println(punto);
//            System.out.println(letra + "\n");
        }
//        int cLetras, cNumeros, cMail, cSigno, cPunto;
        if (puntoA == 1 && puntoO == 1  && cLetras==0 && cNumeros !=0 && (cMail==1 || cSigno !=0 || cPunto!=0) && cEspecial==0) {
            mai = true;
        }else{
            mai = false;
        }
        System.out.println("Boolean Coordenadas: " + mai);
        return mai;
    }
}
