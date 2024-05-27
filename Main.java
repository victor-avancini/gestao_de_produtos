import exceptions.NegativePriceException;
import exceptions.NotFoundException;
import java.util.Scanner;
import product.ProductController;
import product.ProductModel;


public class Main {
    public static void main(String[] args) {
        ProductController controller = new ProductController();

        Scanner scanner = new Scanner(System.in);

        while (true) { 
            System.out.println("\nEscolha uma opção");
            System.out.println("1. Adicionar novo produto");
            System.out.println("2. Listar todos os produtos");
            System.out.println("3. Buscar preço pelo código de barras");
            System.out.println("4. Sair");
            System.out.print("Opção: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Digite o código de barras: ");
                        String barCode = scanner.nextLine();

                        System.out.print("Digite o nome do produto: ");
                        String name = scanner.nextLine();

                        System.out.print("Digite o preço do produto em centavos: ");
                        int priceInCents = scanner.nextInt();

                        System.out.print("Digite a quantidade em estoque: ");
                        int stock = scanner.nextInt();
                        scanner.nextLine();

                        ProductModel product = new ProductModel(barCode);
                        product.setName(name);
                        product.setPriceInCents(priceInCents);
                        product.setStock(stock);

                        String response = controller.create(product);
                        System.out.println(response);

                    } catch (NegativePriceException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    System.out.println("Lista de produtos:");
                    for (ProductModel product : controller.read()) {
                        System.out.println("Código de barras: " + product.getBarCode() + ", Nome: " + product.getName() + ", Preço: " + product.getPriceInCents() + ", Estoque: " + product.getStock());
                    }
                    break;

                case 3: 
                    System.out.print("Digite o código de barras: ");
                    String barCode = scanner.nextLine();
                    try {
                        int price = controller.retrievePrice(barCode);
                        System.out.println("Preço do produto com código de barras " + barCode + ": " + price);
                    } catch (NotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                    
                case 4:
                    System.out.println("Saindo...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Opção inválida. Tente novamente");
            }
        }
    }

    // métodos auxiliares para teste (caso precise).
}
