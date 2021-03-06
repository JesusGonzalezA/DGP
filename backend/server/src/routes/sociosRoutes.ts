import { Router } from 'express';

import { sociosController } from '../controllers/sociosController';

class SociosRoutes {

    public router: Router = Router();

    constructor() {
        this.config();
    }

    public config(): void {
        this.router.get('/', sociosController.list);
        this.router.get('/:id', sociosController.getOne);
        this.router.post('/', sociosController.create);
        this.router.put('/:id/objetivos/add/:idact', sociosController.add);
        this.router.delete('/:id', sociosController.delete);
        this.router.put('/:id', sociosController.update);   
        this.router.get('/:id/actividades', sociosController.getActividades);
        this.router.get('/:id/actividades/solucion/:actividad', sociosController.getActividad);
        this.router.put('/:id/actividades/solucion/:actividad', sociosController.updateSolucion);
        this.router.get('/:id/objetivos', sociosController.getObjetivos);
        this.router.get('/:id/actividades/entregadas', sociosController.getActividadesEntregadas);
        this.router.get('/:id/actividades/no-aceptadas', sociosController.getActividadesPendientesCorregir);
        this.router.get('/:id/actividades/no-entregadas', sociosController.getActividadesSinEntregar);
        this.router.get('/:id/actividades/no-asignadas', sociosController.getActividadesSinAsignar);
        this.router.get('/login/:contrasena', sociosController.getSocio);
    }

}  
const sociosRoutes = new SociosRoutes();
export default sociosRoutes.router;